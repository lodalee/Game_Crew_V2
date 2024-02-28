package com.example.game_crew_v2.exception;

import org.springframework.http.HttpStatus;

public class DuplicateException extends IllegalStateException {
    private HttpStatus httpStatus;
    private String msg;

    public DuplicateException(String msg, HttpStatus httpStatus) {
        this.msg = msg;
        this.httpStatus = httpStatus;
    }
}
