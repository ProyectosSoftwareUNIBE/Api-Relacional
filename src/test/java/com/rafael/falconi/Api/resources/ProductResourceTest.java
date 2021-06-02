package com.rafael.falconi.Api.resources;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductResourceTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    private RestService restService;


    @Test
    public void getAllProduct() {
      String json=restService
              .restBuilder(new RestBuilder<String>().clazz(String.class))
              .path(ProductResource.PRODUCT).get().build();
        System.out.println(json);
    }

    @Test
    public void getById() {
        String json=restService
                .restBuilder(new RestBuilder<String>().clazz(String.class))
                .path(ProductResource.PRODUCT).path(ProductResource.ID).expand(1).get().build();
        System.out.println(json);
    }
}