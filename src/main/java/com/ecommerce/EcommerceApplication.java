package com.ecommerce;

import com.ecommerce.api.IProductService;
import com.ecommerce.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcommerceApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(EcommerceApplication.class);

    @Autowired
    @Qualifier("fakeProductService")
    private IProductService productService;

    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {

        SpringApplication.run(EcommerceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       /* List<Product> productList =  productService.getAllProducts();
        Optional<List<Product>> optionalProductList = Optional.ofNullable(productList);
        if(optionalProductList.isEmpty()){
            log.error("Error loading data from FakeStore in H2 DB");
        }
        else {
            log.info("Products are added in database.");
            productRepository.saveAll(productList);
        }*/
    }
}
