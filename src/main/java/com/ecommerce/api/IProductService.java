package com.ecommerce.api;

import com.ecommerce.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> getAllProducts();
    Product getProductById(long id);
    Product addProduct(Product product);
    Product updateProduct(Product product);
    Product deleteProduct(long id);
    Optional<Product> checkIdempotency(long id);
}
