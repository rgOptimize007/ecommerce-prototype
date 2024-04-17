package com.ecommerce.services;

import com.ecommerce.model.FakeRepoProduct;
import com.ecommerce.model.Product;
import com.ecommerce.utilities.ResponseEntityToModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class FakeStoreProductService implements IProductService {

    private RestTemplate restTemplate;
    public static ResponseEntityToModelMapper responseEntityToModelMapper;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Product> getAllProducts() {
       List<LinkedHashMap> fakeRepoProducts = restTemplate.getForObject("https://fakestoreapi.com/products", List.class);
       List<Product> products = new ArrayList<>();
        fakeRepoProducts.forEach(fakeRepoProduct -> {
           Product product = responseEntityToModelMapper.map(fakeRepoProduct);
           products.add(product);
       });
       return products;
    }

    @Override
    public Product getProductById(long id) {
        //call the fake store API to get product by id
        FakeRepoProduct fakeRepoProduct = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeRepoProduct.class);
        return responseEntityToModelMapper.map(fakeRepoProduct);
    }

    @Override
    public ResponseEntity<String> addProduct(Product product) {
        return ResponseEntity.ok("We dont support this functionality for now");
    }

    @Override
    public ResponseEntity<String> updateProduct(Product product) {
        return ResponseEntity.ok("We dont support this functionality for now");
    }

    @Override
    public ResponseEntity<String> deleteProduct(long id) {
        return ResponseEntity.ok("We dont support this functionality for now");
    }
}
