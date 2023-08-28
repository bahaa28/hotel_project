package com.example.hotel.dto;

import com.example.hotel.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomDto {

    private Long id;

    private Date reserveDate;

   // @NotNull(message = "reserve expire date must not be null")
    private Date reserveExpireDate;

   // @NotNull(message = "amount must not be null")
    private Double amount;

}
