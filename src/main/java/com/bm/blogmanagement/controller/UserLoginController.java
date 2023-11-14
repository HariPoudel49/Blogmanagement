package com.bm.blogmanagement.controller;

import com.bm.blogmanagement.config.AuthorizedUser;
import com.bm.blogmanagement.dto.LoginDto;
import com.bm.blogmanagement.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UserLoginController {

    private final UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        return ResponseEntity.ok(userService.login(loginDto));
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout() {
        AuthorizedUser.setUsers(null);
        return ResponseEntity.ok("User successfully logout");
    }
}
