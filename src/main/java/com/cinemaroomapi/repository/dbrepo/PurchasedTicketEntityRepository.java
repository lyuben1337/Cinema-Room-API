package com.cinemaroomapi.repository.dbrepo;

import com.cinemaroomapi.mapper.Mapper;
import com.cinemaroomapi.model.entity.PurchasedTicketEntity;
import com.cinemaroomapi.model.response.PurchasedTicket;
import com.cinemaroomapi.model.response.Ticket;
import com.cinemaroomapi.repository.PurchasedTicketRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface PurchasedTicketEntityRepository extends JpaRepository<PurchasedTicketEntity, String>,
        PurchasedTicketRepository
{
    Mapper mapper = new Mapper();

    @Transactional
    default void addTicket(PurchasedTicket purchasedTicket) {
        save(mapper.toPurchasedTicketEntity(purchasedTicket));
    }

    @Transactional(readOnly = true)
    @Override
    default List<Ticket> getPurchasedTickets() {
        return findAll()
                .stream()
                .map(Ticket::new)
                .toList();
    }

    @Transactional(readOnly = true)
    @Override
    default boolean exists(String token) {
        return existsById(token);
    }

    @Transactional
    @Override
    default Optional<Ticket> removeTicket(String token) {
        if(findById(token).isEmpty()) {
            return Optional.empty();
        }
        var ticket = findById(token).get();
        deleteById(token);
        return Optional.of(mapper.toTicket(ticket));
    }
}