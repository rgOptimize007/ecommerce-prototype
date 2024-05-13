package com.ecommerce.utilities;

import com.ecommerce.model.Category;
import com.ecommerce.model.FakeRepoProduct;
import com.ecommerce.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ResponseEntityToModelMapper {

    public static Product map(FakeRepoProduct fakeRepoProduct) {
        Product product = new Product();
        product.setTitle(fakeRepoProduct.getTitle());
        product.setPrice(fakeRepoProduct.getPrice());
        product.setDescription(fakeRepoProduct.getDescription()
                .substring(0,Math.min(fakeRepoProduct.getDescription().length(),255)));
        Category category = new Category();
        category.setName(fakeRepoProduct.getCategory());
        product.setCategory(category);
        product.setImageUrl(fakeRepoProduct.getImage());
        return product;
    }

    public static FakeRepoProduct map(Product product) {
        FakeRepoProduct fakeRepoProduct = new FakeRepoProduct();
        fakeRepoProduct.setId(product.getProductId());
        fakeRepoProduct.setTitle(product.getTitle());
        fakeRepoProduct.setPrice(product.getPrice());
        fakeRepoProduct.setCategory(product.getCategory().getName());
        fakeRepoProduct.setDescription(product.getDescription());
        fakeRepoProduct.setImage(product.getImageUrl());
        return fakeRepoProduct;
    }


}