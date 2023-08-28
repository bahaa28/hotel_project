package com.example.hotel.dto;

import com.github.dozermapper.core.Mapping;
import com.googlecode.jmapper.annotations.JMap;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto{

    private Long id;

    private String username;

    private String firstName;

    private String lastName;

    @Mapping("birthDate")
    private Date birthday;

}