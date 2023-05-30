package com.cinemaroomapi.controller.advice;

import com.cinemaroomapi.exception.TicketAlreadyPurchasedException;
import com.cinemaroomapi.exception.TicketOutOfBoundsException;
import com.cinemaroomapi.exception.WrongPasswordException;
import com.cinemaroomapi.exception.WrongTokenException;
import com.cinemaroomapi.model.response.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CinemaControllerAdvice {
    @ExceptionHandler({TicketAlreadyPurchasedException.class,
            TicketOutOfBoundsException.class,
            WrongTokenException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDTO badRequestError(Exception ex) {
        return new ErrorDTO(ex.getMessage());
    }

    @ExceptionHandler(WrongPasswordException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorDTO wrongPasswordError(Exception ex) {
        return new ErrorDTO(ex.getMessage());
    }
}
