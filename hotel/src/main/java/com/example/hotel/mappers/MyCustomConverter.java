package com.example.hotel.mappers;

import com.example.hotel.dto.UserDto;
import com.example.hotel.model.UserEntity;
import org.dozer.CustomConverter;

public class MyCustomConverter implements CustomConverter {

    @Override
    public Object convert(Object destination, Object source, Class<?> aClass, Class<?> aClass1) {
        if(source == null){return null;}
        if(source instanceof UserEntity){
            UserEntity userEntity = ((UserEntity) source);
            return new UserDto(
                    userEntity.getId(),
                    userEntity.getUsername(),
                    userEntity.getFirstName() + " " + userEntity.getLastName(),
                    userEntity.getBirthDate());
        }
        return null;
    }
}
