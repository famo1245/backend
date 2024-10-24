package com.ssafy.sandbox.email.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SendEmailDto {

    private boolean isOk;

    public void setOk(boolean ok) {
        isOk = ok;
    }
}
