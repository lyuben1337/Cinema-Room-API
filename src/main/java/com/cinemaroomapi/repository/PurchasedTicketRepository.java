package com.cinemaroomapi.repository;

import com.cinemaroomapi.model.response.PurchasedTicket;
import com.cinemaroomapi.model.response.Ticket;

import java.util.List;
import java.util.Optional;


public interface PurchasedTicketRepository {

    public List<Ticket> getPurchasedTickets();

    public void addTicket(PurchasedTicket purchasedTicket);

    public boolean exists(String token);

    public Optional<Ticket> removeTicket(String token);

}
