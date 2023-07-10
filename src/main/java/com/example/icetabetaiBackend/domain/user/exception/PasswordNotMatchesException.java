package com.example.toyproject.domain.user.exception;

import com.example.toyproject.global.error.ErrorCode;
import com.example.toyproject.global.error.exception.CustomException;

public class PasswordNotMatchesException extends CustomException {

    public static final CustomException EXCEPTION = new PasswordNotMatchesException();

    public PasswordNotMatchesException() {
        super(ErrorCode.PASSWORD_NOT_MATCHES);
    }

}
