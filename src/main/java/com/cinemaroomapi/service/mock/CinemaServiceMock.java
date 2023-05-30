package com.cinemaroomapi.service.mock;


import com.cinemaroomapi.model.request.Seat;
import com.cinemaroomapi.model.response.CinemaRoomInfo;
import com.cinemaroomapi.model.response.MovieTheatreStats;
import com.cinemaroomapi.model.response.PurchasedTicket;
import com.cinemaroomapi.model.response.ReturnedTicket;
import com.cinemaroomapi.service.CinemaService;
import org.springframework.stereotype.Service;

@Service
public class CinemaServiceMock implements CinemaService {
    @Override
    public CinemaRoomInfo getCinemaRoomInfo() {
        return null;
    }

    @Override
    public PurchasedTicket purchaseTicket(Seat seat) {
        return null;
    }

    @Override
    public ReturnedTicket returnTicket(String token) {
        return null;
    }

    @Override
    public MovieTheatreStats getMovieTheatreStats(String password) {
        return null;
    }
}
