package com.rafael.falconi.Api.dtos;

import com.rafael.falconi.Api.entities.User;

public class UserDto {

    private String id;
    private String email,password,name;

    public UserDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserDto(User user){
        this.id=user.getId();
        this.name=user.getName();
        this.email=user.getEmail();
    }


    public UserDto() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
