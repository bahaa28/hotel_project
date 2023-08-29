package com.example.hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRoomDto {

    public UserRoomDto(String username,  String firstName, String lastName, Double amount) {
        this.username = username;
        this.name = firstName + " " + lastName;
        this.amount = amount;
    }

    private String username;

    private String name;

    private Double amount;

}