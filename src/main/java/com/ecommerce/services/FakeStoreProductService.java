package com.ecommerce.services;

import com.ecommerce.model.FakeRepoProduct;
import com.ecommerce.model.FakeRepoProductToProductMapper;
import com.ecommerce.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements IProductService {

    private RestTemplate restTemplate;
    private FakeRepoProductToProductMapper mapper;

    public FakeStoreProductService(RestTemplate restTemplate, FakeRepoProductToProductMapper mapper) {
        this.restTemplate = restTemplate;
        this.mapper = mapper;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product getProductById(long id) {
        //call the fake store API to get product by id
        FakeRepoProduct fakeRepoProduct = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeRepoProduct.class);
        return mapper.map(fakeRepoProduct);
    }

    @Override
    public Product addProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Product product) {
        return null;
    }

    @Override
    public void deleteProduct(long id) {

    }
}
