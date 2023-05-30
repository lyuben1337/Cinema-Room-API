package com.cinemaroomapi.service;


import com.cinemaroomapi.model.request.Seat;
import com.cinemaroomapi.model.response.CinemaRoomInfo;
import com.cinemaroomapi.model.response.MovieTheatreStats;
import com.cinemaroomapi.model.response.PurchasedTicket;
import com.cinemaroomapi.model.response.ReturnedTicket;

public interface CinemaService {

    public CinemaRoomInfo getCinemaRoomInfo();

    public PurchasedTicket purchaseTicket(Seat seat);

    public ReturnedTicket returnTicket(String token);

    public MovieTheatreStats getMovieTheatreStats(String password);

}
