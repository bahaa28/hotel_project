package com.example.hotel.controllers;

import com.example.hotel.model.Rooms;
import com.example.hotel.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping
    public List<Rooms> getAll(){
        return roomService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rooms> getById(@PathVariable long id){
       return roomService.getById(id);
    }

    @PostMapping
    public Rooms add(@RequestBody Rooms rooms){
        return roomService.add(rooms);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Rooms> update(
            @PathVariable long id,
            @RequestBody Rooms rooms
    ){
        return roomService.upadte(rooms, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Rooms> delete(@PathVariable long id){
        return roomService.delete(id);
    }

    @PutMapping("/{room_id}/users/{user_id}")
    public ResponseEntity<Rooms> addUser(
            @PathVariable long user_id,
            @PathVariable long room_id
    ){
        return roomService.addUser(user_id, room_id);
    }


}
