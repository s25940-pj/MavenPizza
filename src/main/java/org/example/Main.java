package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.example.pizza.PizzaService;
import org.example.pizza.exceptions.PizzaNotFoundException;
import org.example.pizza.model.Order;
import org.example.pizza.model.Pizza;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static final Logger logger = (Logger) LogManager.getLogger(PizzaService.class);
    public static void main(String[] args) {
        List<Pizza> availablePizzas = List.of(
                new Pizza("Margherita", 10),
                new Pizza("Salami", 20),
                new Pizza("Capricciosa", 30)
        );
        PizzaService pizzaService = new PizzaService(availablePizzas);
        try {
            List<Pizza> ordersToMake = List.of(
                    new Pizza("Margherita", 10),
                    new Pizza("Salami", 20),
                    new Pizza("Capricciosa", 100)
            );
            for (Pizza pizza : ordersToMake) {
                pizzaService.makeOrder(pizza);
            }
            pizzaService.printPlacedOrders();
        }
        catch (PizzaNotFoundException e) {
            logger.error("Pizza not exist error", e);
        }
    }
}