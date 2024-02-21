package com.example.game_crew_v2.global.message;

import org.springframework.http.HttpStatus;

public class MessageResponse {
    private HttpStatus status;
    private String msg;

    public MessageResponse(String msg){
        this.msg = msg;
        this.status = HttpStatus.OK;
    }
}
