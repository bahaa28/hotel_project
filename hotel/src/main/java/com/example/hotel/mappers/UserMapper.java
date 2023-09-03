package com.example.hotel.mappers;

import com.example.hotel.dto.UserDto;
import com.example.hotel.model.UserEntity;
import com.googlecode.jmapper.JMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class UserMapper {

    @Autowired
    Mapper userEntityToDtoMapper;

    public UserDto userToDto(UserEntity userEntity) {
        return userEntityToDtoMapper.map(userEntity, UserDto.class);
    }

}
