package com.cinemaroomapi.service.impl;


import com.cinemaroomapi.config.CinemaProps;
import com.cinemaroomapi.exception.TicketAlreadyPurchasedException;
import com.cinemaroomapi.exception.TicketOutOfBoundsException;
import com.cinemaroomapi.exception.WrongPasswordException;
import com.cinemaroomapi.exception.WrongTokenException;
import com.cinemaroomapi.model.entity.PurchasedTicketEntity;
import com.cinemaroomapi.model.request.Seat;
import com.cinemaroomapi.model.response.*;
import com.cinemaroomapi.repository.PurchasedTicketRepository;
import com.cinemaroomapi.repository.SeatRepository;
import com.cinemaroomapi.repository.dbrepo.PurchasedTicketEntityRepository;
import com.cinemaroomapi.service.CinemaService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Primary
@AllArgsConstructor
@Service
public class CinemaServiceImpl implements CinemaService {
    private CinemaProps cinemaProps;
    private SeatRepository seatRepository;
    private PurchasedTicketEntityRepository purchasedTicketRepository;

    public CinemaRoomInfo getCinemaRoomInfo() {

        return new CinemaRoomInfo(
                cinemaProps.getTotalRows(),
                cinemaProps.getTotalColumns(),
                seatRepository.getAvailableSeatList().stream()
                        .map(this::addPrice).toList()
        );

    }

    private boolean validate(Seat seat) {
        return seat.row() > 0 && seat.row() <= cinemaProps.getTotalRows()
                && seat.column() > 0 && seat.column() <= cinemaProps.getTotalColumns();
    }

    public PurchasedTicket purchaseTicket(Seat seat) {
        if(!validate(seat)) {
            throw new TicketOutOfBoundsException("The number of a row or a column is out of bounds!");
        }
        if(!seatRepository.exists(seat)) {
            throw new TicketAlreadyPurchasedException("The ticket has been already purchased!");
        }
        seatRepository.removeSeat(seat);
        PurchasedTicket purchasedTicket = new PurchasedTicket(
                UUID.randomUUID().toString(),
                addPrice(seat)
        );
        purchasedTicketRepository.addTicket(purchasedTicket);
        return purchasedTicket;
    }

    private Ticket addPrice(Seat seat) {
        return new Ticket(seat, calcPrice(seat));
    }

    private int calcPrice(Seat seat) {
        if(seat.row() <= cinemaProps.getFirstRows())
            return cinemaProps.getHighPrice();
        return cinemaProps.getLowPrice();
    }

    public ReturnedTicket returnTicket(String token) {
        if(!purchasedTicketRepository.exists(token)){
            throw new WrongTokenException("Wrong token!");
        }
        var returnedTicket = purchasedTicketRepository.removeTicket(token);
        seatRepository.addSeat(new Seat(returnedTicket.get()));
        return new ReturnedTicket(returnedTicket.get());
    }

    public MovieTheatreStats getMovieTheatreStats(String password) {
        if(!cinemaProps.getSuperSecret().equals(password)) {
            throw new WrongPasswordException("The password is wrong!");
        }
        return new MovieTheatreStats(
                calcIncome(),
                seatRepository.getAvailableSeatList().size(),
                purchasedTicketRepository.getPurchasedTickets().size()
        );
    }

    private int calcIncome() {
        return purchasedTicketRepository.getPurchasedTickets()
                .stream()
                .mapToInt(Ticket::price)
                .sum();
    }
}
