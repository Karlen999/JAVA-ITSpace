package am.itspace.demo.controller;

import am.itspace.demo.model.Member;
import am.itspace.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;

    @Value("${member.upload.dir}")
    private String uploadDir;

    @GetMapping("/member/save")
    public String saveMember(@RequestParam(value = "id", required = false) Integer id, ModelMap modelMap){

        if (id != null){
            modelMap.addAttribute("member", memberRepository.getOne(id));
        }else {
            modelMap.addAttribute("member", new Member());
        }
        return "saveMember";
    }

    @PostMapping("/member/save")
    public String addMember(@ModelAttribute Member member, @RequestParam("image")MultipartFile image) throws IOException {

        if (image != null){
            String photoUrl = System.currentTimeMillis() + "_"
                    + image.getOriginalFilename();
            File file = new File(uploadDir + File.separator + photoUrl);
            image.transferTo(file);
            member.setPhotoUrl(photoUrl);
        }
        memberRepository.save(member);
        return "redirect:/";
    }

    @GetMapping(value = "member/image")
    public @ResponseBody
    byte[] getImage(@RequestParam("photoUrl") String photoUrl) throws IOException {
        InputStream in = new FileInputStream(uploadDir + File.separator + photoUrl);
        return IOUtils.toByteArray(in);
    }

    @GetMapping("/member/delete")
    public String deleteMember(@RequestParam("id") int id){
        memberRepository.deleteById(id);
        return "redirect:/";
    }
}
