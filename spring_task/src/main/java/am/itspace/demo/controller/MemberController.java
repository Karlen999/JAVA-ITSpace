package am.itspace.demo.controller;

import am.itspace.demo.model.Member;
import am.itspace.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.IOException;


@Controller
@RequiredArgsConstructor
public class MemberController {


    private final MemberService memberService;


    @GetMapping("/member/save")
    public String saveMember(@RequestParam(value = "id", required = false) Integer id, ModelMap modelMap) {

        if (id != null) {
            modelMap.addAttribute("member", memberService.getMember(id));
        } else {
            modelMap.addAttribute("member", new Member());
        }
        return "saveMember";
    }

    @PostMapping("/member/save")
    public String addMember(@ModelAttribute Member member, @RequestParam("image") MultipartFile image) throws IOException, MessagingException {
        memberService.saveMember(member, image);
        return "redirect:/";

    }

    @GetMapping(value = "member/image")
    public @ResponseBody
    byte[] getImage(@RequestParam("photoUrl") String photoUrl) throws IOException {
        return memberService.readImage(photoUrl);
    }

    @GetMapping("/member/delete")
    public String deleteMember(@RequestParam("id") int id) {
        memberService.deleteMember(id);
        return "redirect:/";
    }
}
