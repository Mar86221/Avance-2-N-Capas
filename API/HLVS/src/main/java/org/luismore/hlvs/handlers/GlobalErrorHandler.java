package org.luismore.hlvs.handlers;

import lombok.extern.slf4j.Slf4j;
import org.luismore.hlvs.domain.dtos.GeneralResponse;
import org.luismore.hlvs.exceptions.ResourceNotFoundException;
import org.luismore.hlvs.exceptions.UnauthorizedException;
import org.luismore.hlvs.utils.ErrorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@Slf4j
@ControllerAdvice
public class GlobalErrorHandler {

    private final ErrorMapper errorMapper;

    @Autowired
    public GlobalErrorHandler(ErrorMapper errorMapper) {
        this.errorMapper = errorMapper;
    }

    @ExceptionHandler(Exception.class)
    private ResponseEntity<GeneralResponse> generalExceptionHandler(Exception e) {
        log.error(e.getMessage(), e);
        return GeneralResponse.getResponse(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    private ResponseEntity<GeneralResponse> notFoundExceptionHandler(NoResourceFoundException e) {
        return GeneralResponse.getResponse(HttpStatus.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<GeneralResponse> badRequestExceptionHandler(MethodArgumentNotValidException e) {
        return GeneralResponse.getResponse(
                HttpStatus.BAD_REQUEST,
                errorMapper.map(e.getBindingResult().getFieldErrors())
        );
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    private ResponseEntity<GeneralResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException e) {
        return GeneralResponse.getResponse(HttpStatus.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(UnauthorizedException.class)
    private ResponseEntity<GeneralResponse> unauthorizedExceptionHandler(UnauthorizedException e) {
        return GeneralResponse.getResponse(HttpStatus.UNAUTHORIZED, e.getMessage());
    }
}
