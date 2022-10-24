package org.example.pizza;

import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.example.pizza.exceptions.PizzaNotFoundException;
import org.example.pizza.model.Order;
import org.example.pizza.model.Pizza;

import java.util.ArrayList;
import java.util.List;

public class PizzaService {
    private static final Logger logger = (Logger) LogManager.getLogger(PizzaService.class);
    @Getter @Setter private List<Pizza> availablePizzas;
    @Getter private List<Order> placedOrders = new ArrayList<>();

    public PizzaService(List<Pizza> availablePizzas) {
        this.availablePizzas = availablePizzas;
    }

    public Order makeOrder(Pizza pizza) {
        logger.info("makeOrder method called");
        boolean pizzaNotAvailable = this.getAvailablePizzas()
                .stream()
                .filter(p -> p.getName().equals(pizza.getName()))
                .filter(p -> p.getPrice() == pizza.getPrice()).toList().isEmpty();
        if (pizzaNotAvailable) {
            throw new PizzaNotFoundException();
        }
        else {
            Order order = new Order(this.getPlacedOrders().isEmpty() ? 1 : this.getPlacedOrders().size() + 1, pizza);
            placedOrders.add(order);
            return order;
        }
    }

    public void printAvailablePizzas() {
        logger.info("printAvailablePizzas method called");
        for (Pizza pizza : this.getAvailablePizzas()) {
            System.out.println(pizza.getName());
        }
    }

    public void printPlacedOrders() {
        logger.info("printPlacedOrders method called");
        for (Order order : this.getPlacedOrders()) {
            System.out.println(order.getNumber() + " | " + order.getPizza().getName() + " | " + order.getPizza().getPrice() + "$");
        }
    }
}
