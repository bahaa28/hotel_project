package com.example.hotel.mappers;

import com.example.hotel.dto.RoomDto;
import com.example.hotel.model.Rooms;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomMapper {

    //@Autowired
    //private ModelMapper modelMapper;

    @Autowired
    private MapperFactory mapperFactory;


    public RoomDto roomToDto(Rooms room){
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(Rooms.class, RoomDto.class)
                .byDefault()
                .register();
        MapperFacade mapper = mapperFactory.getMapperFacade();

        return mapper.map(room, RoomDto.class);
    }

}
