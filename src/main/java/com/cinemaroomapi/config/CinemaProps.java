package com.cinemaroomapi.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Getter
@Configuration
@Setter
public class CinemaProps {
    @Value("${cinema.total-rows}")
    private int totalRows;

    @Value("${cinema.total-columns}")
    private int totalColumns;

    @Value("${cinema.first-rows}")
    private int firstRows;

    @Value("${cinema.super-secret}")
    private String superSecret;

    @Value("${cinema.price.high}")
    int highPrice;

    @Value("${cinema.price.low}")
    int lowPrice;
}


