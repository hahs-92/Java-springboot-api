package com.platzi.market.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {
    private int  id;
    private String category;
    private boolean active;
}
