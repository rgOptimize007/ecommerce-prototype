package com.ecommerce.services;

import com.ecommerce.model.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();
    Product getProductById(long id);
    ResponseEntity<?> addProduct(Product product);
    ResponseEntity<?> updateProduct(Product product);
    ResponseEntity<?> deleteProduct(long id);
}
