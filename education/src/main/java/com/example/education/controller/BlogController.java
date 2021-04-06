package com.example.education.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {

    @GetMapping("/blog-default")
    public String blogDefault(){
        return "blog-default";
    }

    @GetMapping("/blog-grid")
    public String blogGrid(){
        return "blog-grid";
    }

    @GetMapping("/blog-post")
    public String blogPost(){
        return "blog-post";
    }


}
