package com.example.icetabetaiBackend.global.error;

import lombok.Getter;

@Getter
public class ErrorResponse {

    private final int status;
    private final String message;
    public ErrorResponse(ErrorCode errorCode, String reason){
        this.status = errorCode.getHttpStatus();
        this.message = errorCode.getMessage();
    }

}