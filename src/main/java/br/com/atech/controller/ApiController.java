package br.com.atech.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.atech.entity.ApiResponse;
import br.com.atech.exception.ResourceNotFoundException;

public abstract class ApiController {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse handleResourceNotFoundException(ResourceNotFoundException e) {
        return new ApiResponse(HttpStatus.NOT_FOUND, e.getMessage());
    }
}
