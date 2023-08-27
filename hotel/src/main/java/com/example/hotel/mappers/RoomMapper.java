package com.example.hotel.mappers;

import com.example.hotel.dto.RoomDto;
import com.example.hotel.model.Rooms;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomMapper {

    @Autowired
    private ModelMapper modelMapper;

    public RoomDto roomToDto(Rooms room){
        return modelMapper.map(room, RoomDto.class);
    }

}
