package com.example.hotel.mappers;

import com.example.hotel.dto.UserRoomDto;
import com.example.hotel.model.Rooms;
import com.example.hotel.model.UserEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserRoomMapper {

    @Mapping(source = "userEntity.username", target = "username")
    @Mapping(source = "userEntity.firstName", target = "firstName")
    @Mapping(source = "userEntity.lastName", target = "lastName")
    @Mapping(target = "amount",expression = "java(calculateTotalAmount(rooms))")
    UserRoomDto getUserRoomDetails(UserEntity userEntity, List<Rooms> rooms);

    default Double calculateTotalAmount(List<Rooms> rooms) {
        if (rooms != null) {
            return rooms.stream()
                    .mapToDouble(Rooms::getAmount)
                    .sum();
        }
        return 0.0;
    }
}