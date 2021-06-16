package com.rafael.falconi.Api.controllers;

import com.rafael.falconi.Api.dtos.UserDto;
import com.rafael.falconi.Api.entities.User;
import com.rafael.falconi.Api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        this.userRepository.save(user);
    }

    public UserDto login(UserDto userDto) {
        Optional<User> userOptional = this.userRepository.findUserByEmail(userDto.getEmail());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            UserDto userDto1;
            if (user.getPassword().equals(userDto.getPassword())) {
                userDto1 = new UserDto(user);
            } else {
                userDto1 = new UserDto();
                userDto1.setEmail(user.getEmail());
            }
            return userDto1;

        } else {
            return new UserDto();
        }

    }
}
