package com.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeRepoProduct {

    private long id;
    private String title;
    private double price;
    private  String description;
    private String category;
    private String image;
    private Rating rating;
}
