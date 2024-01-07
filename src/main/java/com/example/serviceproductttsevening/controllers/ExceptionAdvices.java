package com.example.serviceproductttsevening.controllers;

import com.example.serviceproductttsevening.dtos.ErrorResponseDto;
import com.example.serviceproductttsevening.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvices {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleNotFoundException(Exception exception){
        ErrorResponseDto errorResponseDto=new ErrorResponseDto();
        errorResponseDto.setErrorMessage(exception.getMessage());
        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
    }
//    @ExceptionHandler(NotFoundException.class)
//    public ResponseEntity<String> handleNotFoundException(Exception exception){
//        return new ResponseEntity<>("phat gya", HttpStatus.NOT_FOUND);
//    }
}
