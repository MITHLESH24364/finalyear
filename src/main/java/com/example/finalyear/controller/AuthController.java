package com.example.finalyear.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.finalyear.dto.LoginDto;
import com.example.finalyear.entity.Login;
import com.example.finalyear.service.UserService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/sms/")
public class AuthController {

    @Autowired
    UserService userService;

    @PostMapping("register")
    public ResponseEntity<Login> registerUser(@RequestBody @Valid Login login) {
        Login savedLogin = userService.regsterUser(login);
        return ResponseEntity.ok(savedLogin);
    }

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginDto loginDto) {
        return new ResponseEntity<>(userService.login(loginDto), HttpStatus.OK);
    }

}
