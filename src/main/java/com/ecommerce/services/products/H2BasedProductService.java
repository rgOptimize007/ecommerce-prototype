package com.ecommerce.services.products;

import com.ecommerce.api.IProductService;
import com.ecommerce.exception.ProductNotFoundException;
import com.ecommerce.exception.ProductPersistenceException;
import com.ecommerce.model.Category;
import com.ecommerce.model.Product;
import com.ecommerce.repositories.CategoryRepository;
import com.ecommerce.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Qualifier("h2ProductService")
public class H2BasedProductService implements IProductService {

    private final Logger log = LoggerFactory.getLogger(H2BasedProductService.class);

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public H2BasedProductService(ProductRepository productRepository,CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Product> getAllProducts() {
            List<Product> productList = productRepository.findAll();
            if(productList.isEmpty()){
                throw new ProductNotFoundException("No products found.");
            }
        return productList;
    }

    @Override
    public Product getProductById(long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isEmpty()){
            throw new ProductNotFoundException("No products found.");
        }
        return productOptional.get();
    }

    @Override
    public Product addProduct(Product product) {
        try{
            Optional<Category> categoryOptional =
                    categoryRepository.findById(product.getCategory().getCategoryId());
            if(categoryOptional.isPresent()){
                product.setCategory(categoryOptional.get());
            }
            product = productRepository.save(product);
        }
        catch (Exception e){
            throw new ProductPersistenceException(e.getMessage());
        }
        return product;
    }

    @Override
    public Product updateProduct(Product product) {
         Optional<Product> productOptional = productRepository.findById(product.getProductId());
         if (productOptional.isPresent()){
             Product dbProduct = productOptional.get();
             dbProduct.setTitle(product.getTitle());
             dbProduct.setDescription(product.getDescription());
             dbProduct.setImageUrl(product.getImageUrl());
             dbProduct.setPrice(product.getPrice());
             product = productRepository.save(dbProduct);
         }
         else{
             throw new ProductNotFoundException("Can't update the non-existing product.");
         }
         return product;
    }

    @Override
    public Product deleteProduct(long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isEmpty()){
            throw new ProductNotFoundException("Can not delete non-existing product [ID : " + id + "]");
        }
        productRepository.deleteById(id);
        return productOptional.get();
    }

    @Override
    public Optional<Product> checkIdempotency(long id) {
        return productRepository.findById(id);
    }
}
