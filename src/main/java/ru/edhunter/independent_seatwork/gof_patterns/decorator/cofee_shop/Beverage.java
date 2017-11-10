package ru.edhunter.independent_seatwork.gof_patterns.decorator.cofee_shop;

public abstract class Beverage {
    private String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
