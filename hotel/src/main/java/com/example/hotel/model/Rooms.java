package com.example.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Rooms")
public class Rooms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reserveDate")
    private Date reserveDate = new Date();

    @Column(name = "reserveExpireDate")
    @NotNull(message = "reserve expire date must not be null")
    private Date reserveExpireDate;

    @Column(name = "amount")
    @NotNull(message = "amount must not be null")
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

}
