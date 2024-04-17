package com.ecommerce.controller;

import com.ecommerce.model.Product;
import com.ecommerce.services.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private IProductService productService;

    public ProductsController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        //call the service to get all products
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable long id){
        //call the service to get product by id
        return productService.getProductById(id);
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> addProduct(@RequestBody Product product){
        //call the service to add product
        ResponseEntity<String> response = (ResponseEntity<String>) productService.addProduct(product);
        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@RequestBody Product product){
        //call the service to update product
        ResponseEntity<String> response = (ResponseEntity<String>) productService.updateProduct(product);
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable long id){
        //call the service to delete product
        return (ResponseEntity<String>) productService.deleteProduct(id);
    }
}
