package com.rafael.falconi.Api.resources;

import com.rafael.falconi.Api.controllers.UserController;
import com.rafael.falconi.Api.dtos.UserDto;
import com.rafael.falconi.Api.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AuthResource.AUTH)
public class AuthResource {

    public static final String AUTH = "/auth";
    public static final String LOGIN = "/login";

    private UserController userController;

    @Autowired
    public AuthResource(UserController userController) {
        this.userController = userController;
    }

    @PostMapping
    public void createUser(@RequestBody User user) {
        this.userController.createUser(user);
    }

    @PostMapping(value = LOGIN)
    public ResponseEntity<Object> login(@RequestBody UserDto userDto) {
        UserDto response = this.userController.login(userDto);
        if (response.getEmail() == null) {
            return new ResponseEntity<>("\"El usuario no  existe\"", HttpStatus.BAD_REQUEST);
        } else if (response.getName() == null) {
            return new ResponseEntity<>("\"Los datos ingresados son incorrectos\"", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<Object>(response, HttpStatus.ACCEPTED);
        }

    }


}
