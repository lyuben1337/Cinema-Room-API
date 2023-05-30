package com.cinemaroomapi.mapper;

import com.cinemaroomapi.model.entity.PurchasedTicketEntity;
import com.cinemaroomapi.model.response.PurchasedTicket;
import com.cinemaroomapi.model.response.Ticket;

public class Mapper {
    public PurchasedTicketEntity toPurchasedTicketEntity(PurchasedTicket purchasedTicket) {
        return PurchasedTicketEntity.builder()
                .row(purchasedTicket.ticket().row())
                .column(purchasedTicket.ticket().column())
                .token(purchasedTicket.token())
                .price(purchasedTicket.ticket().price())
                .build();
    }

    public Ticket toTicket(PurchasedTicketEntity purchasedTicketEntity) {
        return Ticket.builder()
                .row(purchasedTicketEntity.getRow())
                .column(purchasedTicketEntity.getColumn())
                .price(purchasedTicketEntity.getPrice())
                .build();
    }
}
