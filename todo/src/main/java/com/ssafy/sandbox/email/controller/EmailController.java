package com.ssafy.sandbox.email.controller;

import com.ssafy.sandbox.email.dto.SendEmailDto;
import com.ssafy.sandbox.email.service.EmailService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @PostMapping()
    public ResponseEntity<?> sendEmail(@RequestParam("email") String email) {
        log.debug("request email: {}", email);

        try {
            emailService.sendEmail(email);
            SendEmailDto dto = SendEmailDto.builder()
                    .isOk(true)
                    .build();
            return ResponseEntity.ok().body(dto);
        } catch (MessagingException e) {
            log.error("{}", e.getMessage());
            SendEmailDto dto = SendEmailDto.builder()
                    .isOk(false)
                    .build();
            return ResponseEntity.ok().body(dto);
        }
    }
}
