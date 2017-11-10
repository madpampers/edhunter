package ru.edhunter.independent_seatwork.gof_patterns.factory_method.pizza_store;

public class ChicagoStylePizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        switch (type) {
            case "cheese" : {
                return new ChicagoStyleCheesePizza();
            }
            case "pepperoni" : {
                return new ChicagoStylePepperoniPizza();
            }
            case "clam" : {
                return new ChicagoStyleClamPizza();
            }
            case "veggie" : {
                return new ChicagoStyleVaggiePizza();
            }
        }
        return null;
    }
}
