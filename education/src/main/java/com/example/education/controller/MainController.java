package com.example.education.controller;

import com.example.education.model.User;
import com.example.education.repository.UserRepository;
import com.example.education.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;

    @GetMapping("/")
    public String main(ModelMap modelMap){
        return "index";
    }

    @PostMapping("/")
    public String registerTrial(@ModelAttribute User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/login";

    }

    @GetMapping("/login")
    public String login(ModelMap modelMap){
        return "login";
    }

    @GetMapping("/register")
    public String registerGet(){
        return "register";
    }


    @PostMapping("/register")
    public String registerPost(@ModelAttribute User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        emailService.send(user.getEmail(), "Welcome Subject",
                "Hello " + user.getName() + " You have registered successfully");
        return "redirect:/login";

    }

    @GetMapping("/about")
    public String aboutUs(){
        return "about";
    }

    @GetMapping("/contact")
    public String ContactWithUs(){
        return "contact";
    }
}
