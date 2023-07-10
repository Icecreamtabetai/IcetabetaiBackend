package com.example.toyproject.domain.user.exception;

import com.example.toyproject.global.error.ErrorCode;
import com.example.toyproject.global.error.exception.CustomException;

public class UserNotFoundException extends CustomException {
    public static final CustomException EXCEPTION = new UserNotFoundException();
    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
