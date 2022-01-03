package com.platzi.market.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private int id;
    private String name;
    private int categoryId;
    private double price;
    private int stock;
    private boolean active;
    private  Category category;
    //no se incluyo barCode
}
