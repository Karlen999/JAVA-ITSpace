package am.itspace.demo.service.impl;

import am.itspace.demo.model.Member;
import am.itspace.demo.repository.MemberRepository;
import am.itspace.demo.service.EmailService;
import am.itspace.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.*;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final EmailService emailService;

    @Value("${member.upload.dir}")
    private String uploadDir;

    @Override
    public void saveMember(Member member, MultipartFile multipartFile) throws IOException, MessagingException {
        boolean imageExists = multipartFile.getOriginalFilename() != null && !multipartFile.getOriginalFilename().isEmpty();
        if (imageExists) {
            String photoUrl = System.currentTimeMillis() + "_"
                    + multipartFile.getOriginalFilename();
            File file = new File(uploadDir + File.separator + photoUrl);
            multipartFile.transferTo(file);
            member.setPhotoUrl(photoUrl);
        }
        memberRepository.save(member);
        if (imageExists) {
            emailService.sendWithAttachment(member.getEmail(), "Welcome Subject",
                    "Hello " + member.getName() + " You have registered successfully", uploadDir + File.separator + member.getPhotoUrl());
        } else {
            emailService.sendHtml(member.getEmail(), "Welcome Subject",
                    "Hello " + member.getName() + "<h1> You have registered successfully </h1> <a href=\"http://localhost:8080\">Open Website </a>");
        }
    }

    @Override
    public byte[] readImage(String photoUrl) throws IOException {
        InputStream in = new FileInputStream(uploadDir + File.separator + photoUrl);
        return IOUtils.toByteArray(in);
    }

    @Override
    public Member getMember(int id) {
        return memberRepository.getOne(id);
    }

    @Override
    public void deleteMember(int id) {
        memberRepository.deleteById(id);
    }
}
