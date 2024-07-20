package com.example.projectsmanagement.src.ProjectsManagement.Infrastructure.Advices;

import com.example.projectsmanagement.src.ProjectsManagement.Infrastructure.DTOS.Responses.BaseResponse;
import com.example.projectsmanagement.src.ProjectsManagement.Infrastructure.Exceptions.*;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.naming.OperationNotSupportedException;

@ControllerAdvice
public class ExceptionHandleFactory {
    @ExceptionHandler(DataIntegrityViolationException.class)
    private ResponseEntity<BaseResponse> handleDataIntegrityViolationException(DataIntegrityViolationException exception) {
        BaseResponse errorResponse = BaseResponse.builder()
                .message(exception.getLocalizedMessage())
                .success(false)
                .httpStatus(HttpStatus.BAD_REQUEST)
                .build();
        return new ResponseEntity<>(errorResponse, errorResponse.getHttpStatus());
    }

    @ExceptionHandler(OperationNotSupportedException.class)
    private ResponseEntity<BaseResponse> handleOperationNotSupportedException(OperationNotSupportedException exception) {
        BaseResponse errorResponse = BaseResponse.builder()
                .message(exception.getLocalizedMessage())
                .success(false)
                .httpStatus(HttpStatus.CONFLICT)
                .build();
        return new ResponseEntity<>(errorResponse, errorResponse.getHttpStatus());
    }

    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<BaseResponse> handleChangeSetNotFoundException(NotFoundException e) {
        BaseResponse errorResponse = BaseResponse.builder()
                .message(e.getLocalizedMessage())
                .success(false)
                .httpStatus(HttpStatus.NOT_FOUND)
                .build();
        return new ResponseEntity<>(errorResponse, errorResponse.getHttpStatus());
    }

    @ExceptionHandler(NotCreateException.class)
    private ResponseEntity<BaseResponse> handleNotCreateException(NotCreateException e) {
        BaseResponse errorResponse = BaseResponse.builder()
                .message(e.getLocalizedMessage())
                .success(false)
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
        return new ResponseEntity<>(errorResponse, errorResponse.getHttpStatus());
    }

    @ExceptionHandler(NotUpdateException.class)
    private ResponseEntity<BaseResponse> handleNotUpdateException(NotUpdateException e) {
        BaseResponse errorResponse = BaseResponse.builder()
                .message(e.getLocalizedMessage())
                .success(false)
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
        return new ResponseEntity<>(errorResponse, errorResponse.getHttpStatus());
    }

    @ExceptionHandler(NotDeleteExeption.class)
    private ResponseEntity<BaseResponse> handleNotDeleteException(NotDeleteExeption e) {
        BaseResponse errorResponse = BaseResponse.builder()
                .message(e.getLocalizedMessage())
                .success(false)
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
        return new ResponseEntity<>(errorResponse, errorResponse.getHttpStatus());
    }

    @ExceptionHandler(TypeException.class)
    private ResponseEntity<BaseResponse> handleTypeException(TypeException e) {
        BaseResponse errorResponse = BaseResponse.builder()
                .message(e.getLocalizedMessage())
                .success(false)
                .httpStatus(HttpStatus.BAD_REQUEST)
                .build();
        return new ResponseEntity<>(errorResponse, errorResponse.getHttpStatus());
    }
}