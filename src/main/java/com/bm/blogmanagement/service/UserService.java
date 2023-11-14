package com.bm.blogmanagement.service;

import com.bm.blogmanagement.dto.LoginDto;
import com.bm.blogmanagement.dto.UserDto;

import java.text.ParseException;

public interface UserService {

    UserDto saveUser(UserDto userDto) throws ParseException;

    String login(LoginDto loginDto);

}
