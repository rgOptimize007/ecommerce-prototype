package com.ecommerce.model;

import org.springframework.stereotype.Component;

@Component
public class FakeRepoProductToProductMapper {

    public static Product map(FakeRepoProduct fakeRepoProduct) {
        Product product = new Product();
        product.setId(fakeRepoProduct.getId());
        product.setTitle(fakeRepoProduct.getTitle());
        product.setPrice(fakeRepoProduct.getPrice());
        product.setDescription(fakeRepoProduct.getDescription());
        Category category = new Category();
        category.setId(1);
        category.setName(fakeRepoProduct.getCategory());
        product.setCategory(category);
        product.setImageUrl(fakeRepoProduct.getImage());
        return product;
    }
}
