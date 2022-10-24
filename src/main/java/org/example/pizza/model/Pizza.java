package org.example.pizza.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Pizza {
    private String name;
    private int price;

    public Pizza(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
