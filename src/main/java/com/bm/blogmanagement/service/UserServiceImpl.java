package com.bm.blogmanagement.service;

import com.bm.blogmanagement.config.AuthorizedUser;
import com.bm.blogmanagement.dto.LoginDto;
import com.bm.blogmanagement.dto.UserDto;
import com.bm.blogmanagement.entity.Users;
import com.bm.blogmanagement.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;


    @Override
    public UserDto saveUser(UserDto userDto) throws ParseException {
        Users user = new Users();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse(userDto.getDateOfBirth()));
        user.setPassword(userDto.getPassword());
        userRepo.save(user);
        return userDto;
    }

    @Override
    public String login(LoginDto loginDto) {
        Users users = userRepo.getUsersByUserName(loginDto.getUserName());
        if (users == null) {
            throw new RuntimeException("Invalid username and password");
        }
        if (users.getPassword().equals(loginDto.getPassword())) {
            AuthorizedUser.setUsers(users);
            return "user login successfully !";
        } else {
            throw new RuntimeException("Invalid username and password");
        }
    }
}
