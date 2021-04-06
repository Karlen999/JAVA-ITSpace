package com.example.education.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CourseController {

    @GetMapping("/course-details")
    public String courseDetails(){
        return "course-details";
    }

    @GetMapping("/courses-grid")
    public String coursesGrid(){
        return "courses-grid";
    }


}
