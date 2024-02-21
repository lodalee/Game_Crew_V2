package com.example.game_crew_v2.global.exception;

import org.springframework.http.HttpStatus;

public class DuplicateException extends IllegalStateException {
    private HttpStatus httpStatus;

    public DuplicateException(String msg) {
        super(msg);
        httpStatus = HttpStatus.CONFLICT;
    }
}
