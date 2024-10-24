package com.ssafy.sandbox.email.controller;

import com.ssafy.sandbox.email.dto.EmailRequestDto;
import com.ssafy.sandbox.email.dto.SendEmailDto;
import com.ssafy.sandbox.email.dto.VerifyEmailDto;
import com.ssafy.sandbox.email.service.EmailService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@Slf4j
@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @PostMapping()
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequestDto requestDto) {
        log.debug("request email: {}", requestDto.getEmail());

        try {
            emailService.sendEmail(requestDto.getEmail());
            SendEmailDto dto = SendEmailDto.builder()
                    .isOk(true)
                    .build();
            return ResponseEntity.ok().body(dto);
        } catch (MessagingException e) {
            log.error("{}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/authentication")
    public ResponseEntity<?> verifyEmail(@RequestBody EmailRequestDto requestDto) {
        log.debug("email: {}, code: {}", requestDto.getEmail(), requestDto.getAuthentication());

        try {
            boolean result = emailService.verify(requestDto.getEmail(), requestDto.getAuthentication());
            VerifyEmailDto dto = VerifyEmailDto.builder()
                    .isSuccess(result)
                    .build();
            return ResponseEntity.ok().body(dto);
        } catch (NoSuchElementException e) {
            log.error("{}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}
