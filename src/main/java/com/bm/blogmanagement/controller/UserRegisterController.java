package com.bm.blogmanagement.controller;

import com.bm.blogmanagement.dto.UserDto;
import com.bm.blogmanagement.entity.Users;
import com.bm.blogmanagement.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/api/users")
public class UserRegisterController {
    private final UserService userService;

    public UserRegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto) throws ParseException {
         userDto = userService.saveUser(userDto);
        return ResponseEntity.ok(userDto);
    }
}
