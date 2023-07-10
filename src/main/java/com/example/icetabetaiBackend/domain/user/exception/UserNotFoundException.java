package com.example.icetabetaiBackend.domain.user.exception;

import com.example.icetabetaiBackend.global.error.ErrorCode;
import com.example.icetabetaiBackend.global.error.exception.CustomException;

public class UserNotFoundException extends CustomException {
    public static final CustomException EXCEPTION = new UserNotFoundException();
    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
