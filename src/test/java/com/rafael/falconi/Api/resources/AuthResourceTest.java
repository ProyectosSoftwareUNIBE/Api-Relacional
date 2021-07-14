package com.rafael.falconi.Api.resources;

import com.rafael.falconi.Api.dtos.UserDto;
import com.rafael.falconi.Api.entities.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuthResourceTest {

    @Autowired
    private RestService restService;

    private UserDto userDto;
    private User user;

    @Before
    public void Before(){
        userDto=new UserDto();
        user=new User();
        userDto.setEmail("email@gmail.com");
        userDto.setPassword("1235");
        user.setEmail("test@gmail.com");
        user.setPassword("1235");
        user.setName("Rafael");
        user.setPhone("123124");
    }

    @Test
    public void createUser() {
        String json=
                restService.restBuilder(new RestBuilder<String>().clazz(String.class))
                        .path(AuthResource.AUTH)
                        .body(this.user).post().build();
        System.out.println(json);
    }

    @Test
    public void login() {
        String json=
                restService.restBuilder(new RestBuilder<String>().clazz(String.class))
                        .path(AuthResource.AUTH).path(AuthResource.LOGIN)
                        .body(this.userDto).post().build();
        System.out.println(json);
    }
}