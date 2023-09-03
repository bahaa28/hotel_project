package com.example.hotel.mappers;

import com.example.hotel.dto.UserDto;
import com.example.hotel.model.UserEntity;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDtoMapper{

    @Autowired
    private MapperFactory mapperFactory;

    public UserDto userToDto(UserEntity userEntity) {

        mapperFactory.classMap(UserEntity.class, UserDto.class)
                .field("firstName", "name")
                .field("birthDate", "birthday")
                .byDefault()
                .register();

        MapperFacade mapperFacade = mapperFactory.getMapperFacade();

        return mapperFacade.map(userEntity, UserDto.class);
    }


}