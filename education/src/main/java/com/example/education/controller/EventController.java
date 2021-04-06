package com.example.education.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventController {

    @GetMapping("/event")
    public String event(){
        return "event";
    }

    @GetMapping("/event-details")
    public String eventDetails(){
        return "event-details";
    }


}
