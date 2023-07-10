package com.example.toyproject.domain.user.exception;

import com.example.toyproject.global.error.ErrorCode;
import com.example.toyproject.global.error.exception.CustomException;

public class AlreadyExistException extends CustomException {
    public static final CustomException EXCEPTION = new AlreadyExistException();

    public AlreadyExistException(){
        super(ErrorCode.ALREADY_EXIST);
    }
}
