package com.ssafy.sandbox.email.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class VerifyEmailDto {

    boolean isSuccess;

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
