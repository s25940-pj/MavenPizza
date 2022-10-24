package org.example.pizza.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Order {
    private int number;
    private Pizza pizza;
    private int price;

    public Order(int number, Pizza pizza) {
        this.number = number;
        this.pizza = pizza;
        this.price = pizza.getPrice();
    }
}
