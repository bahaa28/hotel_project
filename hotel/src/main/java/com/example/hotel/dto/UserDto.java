package com.example.hotel.dto;

import lombok.AllArgsConstructor;

import java.util.Date;
import java.util.List;


public record UserDto(
        Long id,
        String username,
        String firstName,
        String lastName,
        Date birthDate,
        List<String> roles
) {
}
