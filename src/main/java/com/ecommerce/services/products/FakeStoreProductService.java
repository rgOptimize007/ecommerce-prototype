package com.ecommerce.services.products;

import com.ecommerce.api.IProductService;
import com.ecommerce.exception.ProductNotFoundException;
import com.ecommerce.model.FakeRepoProduct;
import com.ecommerce.model.Product;
import com.ecommerce.utilities.ResponseEntityToModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Qualifier("fakeProductService")
public class FakeStoreProductService implements IProductService {

    private final RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Product> getAllProducts() {
            List<FakeRepoProduct> fakeRepoProducts = restTemplate.exchange(
                    "https://fakestoreapi.com/products",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<FakeRepoProduct>>() {}).getBody();
            if(fakeRepoProducts == null) {
                throw new ProductNotFoundException("No products found");
            }
            List<Product> products = new ArrayList<>();
            fakeRepoProducts.forEach(fakeRepoProduct -> {
                Product product = ResponseEntityToModelMapper.map(fakeRepoProduct);
                products.add(product);
            });

       return products;
    }

    @Override
    public Product getProductById(long id) {
        //call the fake store API to get product by id
        FakeRepoProduct fakeRepoProduct = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeRepoProduct.class);
        if(fakeRepoProduct == null) {
            throw new ProductNotFoundException("No product found with id: " + id);
        }
        return ResponseEntityToModelMapper.map(fakeRepoProduct);
    }

    @Override
    public Product addProduct(Product product) {
        FakeRepoProduct fakeRepoProduct = ResponseEntityToModelMapper.map(product);
        fakeRepoProduct = restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                fakeRepoProduct,FakeRepoProduct.class);

        if ( Optional.ofNullable(fakeRepoProduct).isEmpty()){
            throw new ProductNotFoundException("No product found for given ID : " + product.getProductId());
        }

        return ResponseEntityToModelMapper.map(fakeRepoProduct);
    }

    @Override
    public Product updateProduct(Product product) {
        return null;
    }

    @Override
    public Product deleteProduct(long id) {
        return null;
    }

    @Override
    public Optional<Product> checkIdempotency(long id) {
        return Optional.empty();
    }
}
