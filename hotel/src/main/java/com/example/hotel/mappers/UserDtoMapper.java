package com.example.hotel.mappers;

import com.example.hotel.dto.UserDto;
import com.example.hotel.model.UserEntity;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;


@Service
public class UserDtoMapper implements Function<UserEntity, UserDto> {

    @Override
    public UserDto apply(UserEntity userEntity) {
        return  new UserDto(
                userEntity.getId(),
                userEntity.getLastName(),
                userEntity.getUsername() + " " + userEntity.getFirstName(),
                userEntity.getBirthDate()
                //userEntity.getUser_role()
                //        .stream()
                //        .map(r -> r.getName())
                //        .collect(Collectors.toList())
        );
    }
}