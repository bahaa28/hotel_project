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

    @NotNull(message = "username must not be null")
    @NotEmpty(message = "username must not be empty")
    private String username;

    @NotNull(message = "first name must not be null")
    @NotEmpty(message = "first name must not be empty")
    private String name;

    @NotNull(message = "amount must not be null")
    private Double amount;

}