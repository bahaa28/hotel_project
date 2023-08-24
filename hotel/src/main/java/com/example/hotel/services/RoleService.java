package com.example.hotel.services;

import com.example.hotel.exception.ResourceNotFoundException;
import com.example.hotel.model.Role;
import com.example.hotel.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class RoleService{

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAll(){
        return roleRepository.findAll();
    }

    public ResponseEntity<Role> getById(long id){
        Role role = roleRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Role not exists with id: " + id));

        return ResponseEntity.ok(role);
    }

    public Role add(@Valid Role role){
        return roleRepository.save(role);
    }

    public ResponseEntity<Role> update(@Valid Role role, long id){
        Role updated = roleRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Role not exists with id: " + id));

        updated.setName(role.getName());
        roleRepository.save(updated);

        return ResponseEntity.ok(updated);
    }

    public ResponseEntity<Role> delete(long id){
        Role role = roleRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Role not exists with id: " + id));
        roleRepository.delete(role);

        return new ResponseEntity<Role>(HttpStatus.NO_CONTENT);
    }


}
