package org.reservation_backend.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
    private int status;
    private String message;
    private String details;

    public ErrorResponse(int status, String message){
        this.status = status;
        this.message = message;
    }

    public ErrorResponse(int status, String message, String details){
        this.status = status;
        this.message = message;
        this.details = details;
    }
}

