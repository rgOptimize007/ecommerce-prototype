package com.ecommerce.utilities;

import com.ecommerce.dto.CategoryDTO;
import com.ecommerce.dto.request.CategoryRequestDTO;
import com.ecommerce.dto.request.ProductRequestDTO;
import com.ecommerce.dto.response.CategoryResponseDTO;
import com.ecommerce.dto.response.ProductResponseDTO;
import com.ecommerce.model.Category;
import com.ecommerce.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ObjectMapperUtility {

    public static ProductResponseDTO map(Product product, ProductResponseDTO productResponseDTO) {
        productResponseDTO.setProductId(product.getProductId());
        productResponseDTO.setTitle(product.getTitle());
        productResponseDTO.setDescription(product.getDescription());
        productResponseDTO.setPrice(product.getPrice());
        productResponseDTO.setImageUrl(product.getImageUrl());
        Category category = product.getCategory();
        CategoryRequestDTO categoryDTO = new CategoryRequestDTO();
        categoryDTO.setCategoryId(category.getCategoryId());
        categoryDTO.setName(category.getName());
        productResponseDTO.setCategory(categoryDTO);
        return productResponseDTO;
    }

    public static Product map(ProductRequestDTO productRequestDTO, Product product) {
        product.setTitle(productRequestDTO.getTitle());
        product.setDescription(productRequestDTO.getDescription());
        product.setPrice(productRequestDTO.getPrice());
        product.setImageUrl(productRequestDTO.getImageUrl().substring(0,Math.min(255,productRequestDTO.getImageUrl().length())));
        CategoryDTO categoryDTO = productRequestDTO.getCategory();
        Category category = new Category();
        category.setCategoryId(categoryDTO.getCategoryId());
        category.setName(categoryDTO.getName());
        product.setCategory(category);
        return product;
    }

    private static CategoryResponseDTO map(Category category, CategoryResponseDTO categoryResponseDTO) {
        categoryResponseDTO.setCategoryId(category.getCategoryId());
        categoryResponseDTO.setName(category.getName());
        List<Product> productList = category.getProductList();
        List<ProductResponseDTO> productResponseDTOList = new ArrayList<>();
        productList.forEach(product -> {
            productResponseDTOList.add(map(product,new ProductResponseDTO()));
        });
        categoryResponseDTO.setProductResponseDTOList(productResponseDTOList);
        return categoryResponseDTO;
    }

    private static Category map(CategoryRequestDTO categoryRequestDTO, Category category) {
        category.setCategoryId(categoryRequestDTO.getCategoryId());
        category.setName(categoryRequestDTO.getName());
        return category;
    }
}
