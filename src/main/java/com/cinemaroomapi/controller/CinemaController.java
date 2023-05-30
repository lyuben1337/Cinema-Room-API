package com.cinemaroomapi.controller;

import com.cinemaroomapi.model.request.Seat;
import com.cinemaroomapi.model.request.Token;
import com.cinemaroomapi.model.response.CinemaRoomInfo;
import com.cinemaroomapi.model.response.MovieTheatreStats;
import com.cinemaroomapi.model.response.PurchasedTicket;
import com.cinemaroomapi.model.response.ReturnedTicket;
import com.cinemaroomapi.service.CinemaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class CinemaController {
    private CinemaService cinemaService;

    @GetMapping("/seats")
    CinemaRoomInfo availableSeats() {
        return cinemaService.getCinemaRoomInfo();
    }

    @PostMapping("/purchase")
    PurchasedTicket purchaseTicket(@RequestBody Seat seat) {
        return cinemaService.purchaseTicket(seat);
    }

    @PostMapping("/return")
    ReturnedTicket returnTicket(@RequestBody Token token) {
        return cinemaService.returnTicket(token.token());
    }

    @PostMapping("/stats")
    MovieTheatreStats getStats(@RequestParam(name = "password", required = false) String password) {
        return cinemaService.getMovieTheatreStats(password);
    }
}
