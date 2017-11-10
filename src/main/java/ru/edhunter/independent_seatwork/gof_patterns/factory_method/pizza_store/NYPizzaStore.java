package ru.edhunter.independent_seatwork.gof_patterns.factory_method.pizza_store;

public class NYPizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        switch (type) {
            case "cheese" : {
                return new NYStyleCheesePizza();
            }
            case "pepperoni" : {
                return new NYStylePepperoniPizza();
            }
            case "clam" : {
                return new NYStyleClamPizza();
            }
            case "veggie" : {
                return new NYStyleVaggiePizza();
            }
        }
        return null;
    }
}
