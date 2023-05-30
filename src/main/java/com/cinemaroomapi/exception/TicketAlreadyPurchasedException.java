package com.cinemaroomapi.exception;

public class TicketAlreadyPurchasedException extends RuntimeException {

    public TicketAlreadyPurchasedException (String message) {
        super(message);
    }

}
