package com.example.hotel.controllers;


import com.example.hotel.dto.UserDto;
import com.example.hotel.dto.UserRoomDto;
import com.example.hotel.model.Role;
import com.example.hotel.model.UserEntity;
import com.example.hotel.services.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserEntityController {

    @Autowired
    private UserEntityService userEntityService;

    @GetMapping
    public List<UserDto> getAll(){
        return userEntityService.getAll();
    }

    @GetMapping("id/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable long id){
        return userEntityService.getById(id);
    }

    @GetMapping("username/{username}")
    public ResponseEntity<UserEntity> getByUsername(@PathVariable String username){
        return userEntityService.getByUsername(username);
    }

    @PostMapping
    public UserEntity add(@RequestBody UserEntity userEntity){
        return userEntityService.add(userEntity);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserEntity> update(
            @PathVariable long id,
            @RequestBody UserEntity userEntity
    ){
        return userEntityService.update(userEntity, id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<UserEntity> delete(@PathVariable long id){
        return userEntityService.delete(id);
    }

    @PutMapping("{user_id}/roles")
    public ResponseEntity<UserEntity> addRole(
            @PathVariable long user_id,
            @RequestBody Role role
    ){
        return userEntityService.addRole(role, user_id);
    }

    @PutMapping("{user_id}/roles/{role_id}")
    public ResponseEntity<UserEntity> addRole(
            @PathVariable long user_id,
            @PathVariable long role_id
    ){
        return userEntityService.addRole(role_id, user_id);
    }
    @PostMapping("list")
    public ResponseEntity<String> addList(@RequestBody List<UserEntity> userEntityList){
        return userEntityService.addList(userEntityList);
    }

    @GetMapping("rooms/userId/{id}")
    public  ResponseEntity<UserRoomDto> getUserRoomDetail(@PathVariable long id){
        return userEntityService.getUserRoomDetail(id);
    }

    @GetMapping("/amount/{amount}")
    public List<UserRoomDto> findUsersNeedToPayMoreThanAmount(@PathVariable double amount){
        return userEntityService.findUsersNeedToPayMoreThanAmount(amount);
    }

}
