package com.cinemaroomapi.model.request;


import com.cinemaroomapi.model.response.Ticket;

public record Seat(
        int row,
        int column
) {
    public Seat(Ticket ticket) {
        this(ticket.row(), ticket.column());
    }
}
