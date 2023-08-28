package com.example.hotel.mappers;

import com.example.hotel.dto.UserDto;
import com.example.hotel.model.UserEntity;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.stereotype.Service;


@Service
public class UserMapper {

    public UserDto userToDto(UserEntity userEntity) {
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        return mapper.map(userEntity, UserDto.class);
    }

}
