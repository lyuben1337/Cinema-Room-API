package com.cinemaroomapi.repository.inmemory;


import com.cinemaroomapi.model.request.Seat;
import com.cinemaroomapi.repository.SeatRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class SeatRepositoryInMemo implements SeatRepository {

    private final Set<Seat> availableSeats = new LinkedHashSet<>();

    public List<Seat> getAvailableSeatList() {
        return availableSeats.stream().toList();
    }

    public void addSeat(Seat seat) {
        availableSeats.add(seat);
    }

    public void removeSeat(Seat seat) {
        availableSeats.remove(seat);
    }

    public boolean exists(Seat seat) {
        return availableSeats.contains(seat);
    }

}

