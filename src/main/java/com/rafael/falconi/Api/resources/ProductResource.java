package com.rafael.falconi.Api.resources;

import com.rafael.falconi.Api.controllers.ProductController;
import com.rafael.falconi.Api.entities.Product;
import com.rafael.falconi.Api.resources.exceptions.EditProductException;
import com.rafael.falconi.Api.resources.exceptions.ProductCreateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(ProductResource.PRODUCT)
public class ProductResource {

    public static final String PRODUCT = "/product";
    public static final String ID = "/{id}";
    public static final String CATEGORYNAME = "/{category}";
    public static final String CATEGORY = "/category";


    private ProductController productController;

    @Autowired
    public ProductResource(ProductController productController) {
        this.productController = productController;
    }

    @GetMapping
    public List<Product> getAllProducts(@RequestParam(required = false) String category) {
        if (category == null) return this.productController.findAllProducts();
        return this.productController.findProductByCategory(category);


    }

    @GetMapping(value = ID)
    public ResponseEntity<Object> getProductById(@PathVariable String id) {
        Optional<Product> productOptional = this.productController.findProductById(id);
        if (productOptional.isPresent()) {
            return new ResponseEntity<>(productOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("\"El producto no  existe\"", HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping(value = CATEGORY + CATEGORYNAME)
    public List<Product> getProducstByCategory(@PathVariable String category) {
        return this.productController.findProductByCategory(category);
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody Product product) throws ProductCreateException {
        try {
            this.productController.createProduct(product);
            return new ResponseEntity<>("\"El producto fue creado\"", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw new ProductCreateException("los datos enviados no son los correctos");
        }

    }

    @PutMapping(value = ID)
    public ResponseEntity<String> editProduct(@RequestBody Product product, @PathVariable String id) throws EditProductException {
        try {
            if (this.productController.editProductById(id, product))
                return new ResponseEntity<>("\"El producto fue edito\"", HttpStatus.ACCEPTED);
            return new ResponseEntity<>("\"El producto no  existe\"", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            throw new EditProductException("los datos enviados no son los correctos");
        }
    }

    @DeleteMapping(value = ID)
    public ResponseEntity<String> deleteProduct(@PathVariable String id){
        if (this.productController.deleteProductById(id))
            return new ResponseEntity<>("\"El producto fue eliminado\"", HttpStatus.ACCEPTED);
        return new ResponseEntity<>("\"El producto no  existe\"", HttpStatus.NOT_FOUND);
    }


}
