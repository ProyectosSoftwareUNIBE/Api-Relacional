package com.rafael.falconi.Api.resources;

import com.rafael.falconi.Api.entities.Product;
import org.junit.Before;
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
    private Product product;

    @Before
    public void before() {
        product=new Product();
        this.product.setName("billetera");
        this.product.setCode("ci-091231");
        this.product.setPrice(10.5);
        this.product.setCategory("extras");
    }

    @Test
    public void getAllProduct() {
        String json = restService
                .restBuilder(new RestBuilder<String>().clazz(String.class))
                .path(ProductResource.PRODUCT).get().build();
        System.out.println(json);
    }

    @Test
    public void getById() {
        String json = restService
                .restBuilder(new RestBuilder<String>().clazz(String.class))
                .path(ProductResource.PRODUCT).path(ProductResource.ID).expand(1).get().build();
        System.out.println(json);
    }

    @Test
    public void getProducstByCategory() {
        String json = restService
                .restBuilder(new RestBuilder<String>().clazz(String.class))
                .path(ProductResource.PRODUCT).path(ProductResource.CATEGORY).path(ProductResource.CATEGORYNAME).expand("ejemplo").get().build();
        System.out.println(json);
    }

    @Test
    public void createProduct() {
        String json = restService
                .restBuilder(new RestBuilder<String>().clazz(String.class))
                .path(ProductResource.PRODUCT).body(this.product).post().build();
        System.out.println(json);

    }
}