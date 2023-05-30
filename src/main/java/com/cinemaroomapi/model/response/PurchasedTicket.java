package com.cinemaroomapi.model.response;

public record PurchasedTicket(
        String token,
        Ticket ticket
) {
}
