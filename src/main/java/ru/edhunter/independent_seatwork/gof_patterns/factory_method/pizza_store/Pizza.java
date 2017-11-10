package ru.edhunter.independent_seatwork.gof_patterns.factory_method.pizza_store;

public interface Pizza {
    void prepare();

    void bake();

    void cut();

    void box();
}
