package com.ecommerce.services;

import com.ecommerce.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();
    Product getProductById(long id);
    Product addProduct(Product product);
    Product updateProduct(Product product);
    void deleteProduct(long id);
}
