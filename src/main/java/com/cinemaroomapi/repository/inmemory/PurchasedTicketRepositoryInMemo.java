package com.cinemaroomapi.repository.inmemory;


import com.cinemaroomapi.model.response.PurchasedTicket;
import com.cinemaroomapi.model.response.Ticket;
import com.cinemaroomapi.repository.PurchasedTicketRepository;

import java.util.*;

public class PurchasedTicketRepositoryInMemo implements PurchasedTicketRepository {

    private final Map<String, Ticket> purchasedTickets = new HashMap<>();

    public List<Ticket> getPurchasedTickets() {
        return purchasedTickets.values().stream().toList();
    }

    public void addTicket(PurchasedTicket purchasedTicket) {
        purchasedTickets.put(purchasedTicket.token(), purchasedTicket.ticket());
    }

    public boolean exists(String token) {
        return purchasedTickets.containsKey(token);
    }

    public Optional<Ticket> removeTicket(String token) {
        return Optional.of(purchasedTickets.remove(token));
    }

}
