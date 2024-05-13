package com.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productId;
    private String title;
    private double price;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "categoryId",nullable = false)
    private Category category;
    private String description;
    private String imageUrl;

}
