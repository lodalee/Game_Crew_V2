package com.example.game_crew_v2.exception;

import com.example.game_crew_v2.message.ExceptionMessage;
import org.springframework.http.HttpStatus;


public class UserNotFoundException extends RuntimeException {
    private HttpStatus httpStatus;
    private String msg;

    public UserNotFoundException() {
        super(ExceptionMessage.USER_NOT_FOUND);
        this.httpStatus = HttpStatus.NOT_FOUND;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
