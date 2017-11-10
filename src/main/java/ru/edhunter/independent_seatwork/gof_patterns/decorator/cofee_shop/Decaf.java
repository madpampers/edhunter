package ru.edhunter.independent_seatwork.gof_patterns.decorator.cofee_shop;

public class Decaf extends Beverage {
    @Override
    public String getDescription() {
        return "Decaf";
    }

    @Override
    public double cost() {
        return 0.99;
    }
}
