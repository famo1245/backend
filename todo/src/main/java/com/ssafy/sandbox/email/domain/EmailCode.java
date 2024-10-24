package com.ssafy.sandbox.email.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Getter
@RedisHash(value= "email_code", timeToLive = 300)
public class EmailCode {

    @Id
    private String id;
    private String email;
    private String code;

    public EmailCode(String email, String code) {
        this.email = email;
        this.code = code;
    }
}