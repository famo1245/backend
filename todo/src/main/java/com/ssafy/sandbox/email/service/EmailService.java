package com.ssafy.sandbox.email.service;

import jakarta.mail.MessagingException;

public interface EmailService {
    void sendEmail(String email) throws MessagingException;
}
