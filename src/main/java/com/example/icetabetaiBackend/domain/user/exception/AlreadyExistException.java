package com.example.icetabetaiBackend.domain.user.exception;

import com.example.icetabetaiBackend.global.error.ErrorCode;
import com.example.icetabetaiBackend.global.error.exception.CustomException;

public class AlreadyExistException extends CustomException {
    public static final CustomException EXCEPTION = new AlreadyExistException();

    public AlreadyExistException(){
        super(ErrorCode.ALREADY_EXIST);
    }
}
