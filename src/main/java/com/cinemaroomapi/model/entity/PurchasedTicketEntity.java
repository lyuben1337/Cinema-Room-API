package com.cinemaroomapi.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class PurchasedTicketEntity {
    @Id
    String token;
    @Column(name = "row_num")
    int row;
    int column;
    int price;
}
