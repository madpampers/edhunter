package ru.edhunter.independent_seatwork.gof_patterns.factory_method.pizza_store;

public abstract class PizzaStore {
    public abstract Pizza createPizza(String type);

    public final Pizza orderPizza(String type) {
        Pizza pizza;

        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
