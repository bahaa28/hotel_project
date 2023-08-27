package com.example.hotel.services;

import com.example.hotel.dto.RoomDto;
import com.example.hotel.exception.ResourceNotFoundException;
import com.example.hotel.mappers.RoomMapper;
import com.example.hotel.model.Rooms;
import com.example.hotel.model.UserEntity;
import com.example.hotel.repositories.RoomRepository;
import com.example.hotel.repositories.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    private RoomMapper roomMapper;

    public List<Rooms> getAll(){
        return roomRepository.findAll();
    }

    public ResponseEntity<RoomDto> getById(long id){
        Rooms room = roomRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("room does not exists with id: " + id));

        RoomDto roomDto = roomMapper.roomToDto(room);

        return ResponseEntity.ok(roomDto);
    }

    public Rooms add(@Valid Rooms room){
        return roomRepository.save(room);
    }

    public ResponseEntity<Rooms> upadte(@Valid Rooms room, long id){
        Rooms updated = roomRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("room does not exists with id: " + id));

        updated.setReserveDate(room.getReserveDate());
        updated.setReserveExpireDate(room.getReserveExpireDate());
        updated.setAmount(room.getAmount());
        updated.setUser(room.getUser());

        roomRepository.save(updated);

        return ResponseEntity.ok(updated);
    }

    public ResponseEntity<Rooms> delete(long id){
        Rooms deleted = roomRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("room does not exists with id: " + id));

        roomRepository.delete(deleted);

        return new ResponseEntity<Rooms>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Rooms> addUser(long user_id, long room_id){
        Rooms rooms = roomRepository.findById(room_id).orElseThrow(() ->
                new ResourceNotFoundException("room does not exists with id: " + room_id));
        UserEntity userEntity = userEntityRepository.findById(user_id).orElseThrow(() ->
                new ResourceNotFoundException("User not exists with id: " + user_id));

        rooms.setUser(userEntity);
        roomRepository.save(rooms);

        return ResponseEntity.ok(rooms);

    }

    public ResponseEntity<Rooms> addUser(@Valid UserEntity userEntity, long room_id){
        Rooms rooms = roomRepository.findById(room_id).orElseThrow(() ->
                new ResourceNotFoundException("room does not exists with id: " + room_id));

        userEntityRepository.save(userEntity);

        rooms.setUser(userEntity);
        roomRepository.save(rooms);

        return ResponseEntity.ok(rooms);
    }

}
