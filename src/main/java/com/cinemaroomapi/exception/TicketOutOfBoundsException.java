package com.cinemaroomapi.exception;

public class TicketOutOfBoundsException extends RuntimeException {
    public TicketOutOfBoundsException(String message) {
        super(message);
    }
}
