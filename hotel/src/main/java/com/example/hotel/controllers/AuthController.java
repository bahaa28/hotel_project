package com.example.hotel.controllers;


import com.example.hotel.dto.AuthResponseDto;
import com.example.hotel.dto.LoginDto;
import com.example.hotel.dto.RegesterDto;
import com.example.hotel.model.Role;
import com.example.hotel.model.UserEntity;
import com.example.hotel.repositories.RoleRepository;
import com.example.hotel.repositories.UserEntityRepository;
import com.example.hotel.security.Constants;
import com.example.hotel.security.JWTGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import java.util.Collections;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTGenerator jwtGenerator;

    @PostMapping("register")
    public ResponseEntity<String> regester(@Valid @RequestBody RegesterDto regesterDto) {
        if (userEntityRepository.existsByUsername(regesterDto.getUsername())) {
            return new ResponseEntity<String>("username is taken", HttpStatus.BAD_REQUEST);
        }
        UserEntity user = new UserEntity();
        user.setUsername(regesterDto.getUsername());
        user.setPassword(passwordEncoder.encode(regesterDto.getPassword()));
        user.setFirstName(regesterDto.getFirstName());
        user.setLastName(regesterDto.getLastName());
        user.setBirthDate(regesterDto.getBirthDate());

        Role role = roleRepository.findByName("USER").get();
        user.setUser_role(Collections.singletonList(role));
        userEntityRepository.save(user);

        return new ResponseEntity<String>("User register successfully", HttpStatus.OK);
    }


    @PostMapping("login")
    public ResponseEntity<AuthResponseDto> login(@Valid @RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtGenerator.generateToken(authentication);


        return new ResponseEntity<AuthResponseDto>(new AuthResponseDto(token), HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request, HttpServletResponse response) {
        // Clear or invalidate the JWT token stored on the client side
        // This can be done by removing cookies or clearing local storage

        // For example, if using cookies, you can clear the token cookie
        Cookie tokenCookie = new Cookie(Constants.TOKEN_HEADER_AUTHORIZATION, null);
        tokenCookie.setMaxAge(0);
        tokenCookie.setHttpOnly(true);
        tokenCookie.setPath("/");
        response.addCookie(tokenCookie);

        // You can also send a response indicating successful logout
        return ResponseEntity.ok("Logged out successfully");
    }


}
