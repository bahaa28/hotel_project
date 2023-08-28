package com.example.hotel.mappers;

import com.example.hotel.dto.RoomDto;
import com.example.hotel.model.Rooms;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomMapper {

    @Autowired
    private ModelMapper modelMapper;

    private void typeMap(){
        if(typeMap == null)
            typeMap = modelMapper.createTypeMap(Rooms.class, RoomDto.class);
    }


    private TypeMap<Rooms, RoomDto> typeMap = null;

    public RoomDto roomToDto(Rooms room){
        typeMap();

        typeMap.addMappings(mapper -> {
           mapper.map(source -> source.getUser().getUsername(), RoomDto::setUsername);
           mapper.map(source -> Math.round(room.getAmount() * 1.1), RoomDto::setAmount);
        });

         return modelMapper.map(room, RoomDto.class);
    }

}