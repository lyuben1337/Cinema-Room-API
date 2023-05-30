package com.cinemaroomapi.repository;


import com.cinemaroomapi.model.request.Seat;

import java.util.*;

public interface SeatRepository {

    List<Seat> getAvailableSeatList();

    void addSeat(Seat seat);

    void removeSeat(Seat seat);

    boolean exists(Seat seat);

}
