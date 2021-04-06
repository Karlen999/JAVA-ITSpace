package com.example.education.service;

public interface EmailService {

    void send(String to, String subject, String text);
}
