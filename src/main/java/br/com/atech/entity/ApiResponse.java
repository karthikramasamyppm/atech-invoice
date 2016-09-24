package br.com.atech.entity;

import org.springframework.http.HttpStatus;

public class ApiResponse {
    private Integer status;
    private String message;

    public ApiResponse(HttpStatus status) {
        this.status = status.value();
        this.message = status.getReasonPhrase();
    }

    public ApiResponse(HttpStatus status, String message) {
        this.status = status.value();
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
