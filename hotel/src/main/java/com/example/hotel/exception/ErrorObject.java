package com.example.hotel.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class ErrorObject {

    private final int httpStatus;
    private final String message;
    private final Date timeStamp;

}
