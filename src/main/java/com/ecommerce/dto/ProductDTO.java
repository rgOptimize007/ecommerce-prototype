package com.ecommerce.dto;

import com.ecommerce.dto.request.CategoryRequestDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class ProductDTO {
     private String title;
     private double price;
     private CategoryRequestDTO category;
     private String description;
     private String imageUrl;
}
