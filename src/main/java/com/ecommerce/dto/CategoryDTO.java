package com.ecommerce.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class CategoryDTO {
    private Long categoryId;
    private String name;
}
