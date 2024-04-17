package com.ecommerce.utilities;

import com.ecommerce.model.Category;
import com.ecommerce.model.FakeRepoProduct;
import com.ecommerce.model.Product;
import com.ecommerce.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;

@Component
public class ResponseEntityToModelMapper {

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

    public static Product map(LinkedHashMap hashObject) {
        Product product = new Product();
        product.setId((int)hashObject.get("id"));
        product.setTitle(hashObject.get("title").toString());
        product.setPrice(Double.valueOf(hashObject.get("price").toString()));
        product.setDescription(hashObject.get("description").toString());
        Category category = new Category();
        category.setName(hashObject.get("category").toString());
        product.setCategory(category);
        product.setImageUrl(hashObject.get("image").toString());
        return product;
    }
}