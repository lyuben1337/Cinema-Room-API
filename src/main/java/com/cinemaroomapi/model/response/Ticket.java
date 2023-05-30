package com.cinemaroomapi.model.response;


import com.cinemaroomapi.model.entity.PurchasedTicketEntity;
import com.cinemaroomapi.model.request.Seat;
import lombok.Builder;

@Builder
public record Ticket (
        int row,
        int column,
        int price
) {
    public Ticket(Seat seat, int price) {
        this(seat.row(), seat.column(), price);
    }

    public Ticket(PurchasedTicketEntity purchasedTicketEntity) {
        this(purchasedTicketEntity.getRow(), purchasedTicketEntity.getColumn(), purchasedTicketEntity.getPrice());
    }
}
