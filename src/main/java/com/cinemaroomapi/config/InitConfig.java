package com.cinemaroomapi.config;

import com.cinemaroomapi.model.request.Seat;
import com.cinemaroomapi.repository.SeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class InitConfig implements CommandLineRunner {

    SeatRepository seatRepository;
    CinemaProps cinemaProps;

    @Override
    public void run(String... args) throws Exception {
        for (int iRow = 1; iRow <= cinemaProps.getTotalRows(); iRow++) {
            for (int iCol = 1; iCol <= cinemaProps.getTotalColumns(); iCol++) {
                seatRepository.addSeat(new Seat(iRow, iCol));
            }
        }
    }
}
