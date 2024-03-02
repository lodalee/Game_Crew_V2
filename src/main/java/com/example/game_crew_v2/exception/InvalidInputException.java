package com.example.game_crew_v2.exception;

import com.example.game_crew_v2.message.ExceptionMessage;
import org.springframework.http.HttpStatus;


public class InvalidInputException extends RuntimeException{
    private HttpStatus httpStatus;
    private String msg;
    public InvalidInputException() {
        super(ExceptionMessage.INVALID_INPUT_EXCEPTION);
        this.httpStatus = HttpStatus.BAD_REQUEST;
    }

    // getHttpStatus 메소드 추가
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
