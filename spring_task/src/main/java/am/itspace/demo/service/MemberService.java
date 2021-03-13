package am.itspace.demo.service;

import am.itspace.demo.model.Member;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface MemberService {

    void saveMember (Member member, MultipartFile multipartFile) throws IOException, MessagingException;

    byte[] readImage(String photoUrl) throws IOException;

    Member getMember(int id);

    void deleteMember(int id);
}
