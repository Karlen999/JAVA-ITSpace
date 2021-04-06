package com.example.education.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {

    @GetMapping("/gallery")
    public String showGallery(){
        return "gallery";
    }

    @GetMapping("/teachers")
    public String showTeachers(){
        return "teachers";
    }

    @GetMapping("/teacher-details")
    public String teacherDetails(){
        return "teacher-details";
    }

    @GetMapping("/faq")
    public String askedQuestionsGet(){
        return "faq";
    }

    @GetMapping("/tables")
    public String getTables(){
        return "tables";
    }

    @GetMapping("/tabs-and-accordions")
    public String getTabs(){
        return "tabs-and-accordions";
    }

    @GetMapping("/coming-soon")
    public String showAds(){
        return "coming-soon";
    }

    @GetMapping("/404-page")
    public String errorPage(){
        return "404-page";
    }

}
