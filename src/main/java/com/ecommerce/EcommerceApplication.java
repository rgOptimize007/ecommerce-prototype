package com.ecommerce;

import com.ecommerce.model.Category;
import com.ecommerce.model.Product;
import com.ecommerce.repositories.CategoryRepository;
import com.ecommerce.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcommerceApplication implements CommandLineRunner{

    private static final Logger log = LoggerFactory.getLogger(EcommerceApplication.class);

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public static void main(String[] args) {

        SpringApplication.run(EcommerceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Category category = new Category();
        category.setId(1);
        category.setName("Electronics");
        categoryRepository.save(new Category(1,"Electronics"));
        categoryRepository.save(new Category(2,"Books"));
        categoryRepository.save(new Category(3,"Clothing"));

        Product product = new Product();
        product.setId(1);
        product.setTitle("Smartphone");
        product.setPrice(1000);
        product.setDescription("A smartphone with 8GB RAM and 256GB storage");
        product.setCategory(category);
        product.setImageUrl("https://example.com/smartphone.jpg");
        productRepository.save(product);
    }
}
