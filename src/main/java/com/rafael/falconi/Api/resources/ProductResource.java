package com.rafael.falconi.Api.resources;

import com.rafael.falconi.Api.controllers.ProductController;
import com.rafael.falconi.Api.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(ProductResource.PRODUCT)
public class ProductResource {

    public static final String PRODUCT = "product";
    public static final String ID = "/{id}";
    public static final String CATEGORYNAME = "/{category}";
    public static final String CATEGORY = "/category";


    private ProductController productController;

    @Autowired
    public ProductResource(ProductController productController) {
        this.productController = productController;
    }

    @GetMapping
    public List<Product> getAllProduct() {
        return this.productController.findAllProducts();
    }

    @GetMapping(value = ID)
    public ResponseEntity getProductById(@PathVariable int id) {
        Optional<Product> productOptional = this.productController.findProductById(id);
        if (productOptional.isPresent()) {
            return new ResponseEntity(productOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity("\"El producto no  existe\"", HttpStatus.NOT_FOUND);
        }

    }


}