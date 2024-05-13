package com.ecommerce.controller;

import com.ecommerce.dto.ProductDTO;
import com.ecommerce.dto.request.ProductRequestDTO;
import com.ecommerce.dto.response.ProductResponseDTO;
import com.ecommerce.model.Product;
import com.ecommerce.api.IProductService;
import com.ecommerce.utilities.ObjectMapperUtility;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private IProductService productService;

    public ProductsController(@Qualifier("h2ProductService") IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        //call the service to get all products
        List<Product> productList = productService.getAllProducts();
        List<ProductDTO> productDTOList = new ArrayList<>();
        productList.forEach(product -> {
            productDTOList.add(ObjectMapperUtility.map(product,new ProductResponseDTO()));
        });
        return ResponseEntity.ok(productDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable long id){
        //call the service to get product by id
        Product product = productService.getProductById(id);
        ProductResponseDTO productResponseDTO = ObjectMapperUtility.map(product,new ProductResponseDTO());
        return ResponseEntity.ok(productResponseDTO);
    }

    @PostMapping("/{id}")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductRequestDTO productRequestDTO,
                                                 @PathVariable("id") Long idempotencyId){
        Product product = ObjectMapperUtility.map(productRequestDTO,new Product());
        Optional<Product> productOptional = productService.checkIdempotency(idempotencyId);
        if(productOptional.isEmpty()){
            product = productService.addProduct(product);
            ProductResponseDTO productResponseDTO = ObjectMapperUtility.map(product,new ProductResponseDTO());
            return ResponseEntity.ok(productResponseDTO);
        }
        return ResponseEntity.ok(productRequestDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductRequestDTO productRequestDTO,
                                                    @PathVariable("id") Long productId){
        //call the service to update product
        Product product = ObjectMapperUtility.map(productRequestDTO,new Product());
        product.setProductId(productId);
        product = productService.updateProduct(product);
        ProductResponseDTO productResponseDTO = ObjectMapperUtility.map(product,new ProductResponseDTO());
        return ResponseEntity.ok(productResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductDTO> deleteProduct(@PathVariable long id){
        //call the service to delete product
        Product product = productService.deleteProduct(id);
        ProductDTO productDTO = ObjectMapperUtility.map(product,new ProductResponseDTO());
        return ResponseEntity.ok(productDTO);
    }
}
