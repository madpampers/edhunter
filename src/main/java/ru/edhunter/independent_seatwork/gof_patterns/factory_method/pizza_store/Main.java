package ru.edhunter.independent_seatwork.gof_patterns.factory_method.pizza_store;

public class Main {
    public static void main(String[] args) {
        PizzaStore nyPizzaStore = new NYPizzaStore();
        final Pizza pizza = nyPizzaStore.orderPizza("cheese");
        System.out.println(pizza.getClass().getSimpleName());

        PizzaStore chicagoPizzaStore = new ChicagoStylePizzaStore();
        final Pizza pizza1 = chicagoPizzaStore.orderPizza("cheese");
        System.out.println(pizza1.getClass().getSimpleName());
    }
}
