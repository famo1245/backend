package com.ssafy.sandbox.email.service;

import jakarta.mail.MessagingException;

import java.util.NoSuchElementException;

public interface EmailService {
    void sendEmail(String email) throws MessagingException;

    boolean verify(String email, String code) throws NoSuchElementException;
}
