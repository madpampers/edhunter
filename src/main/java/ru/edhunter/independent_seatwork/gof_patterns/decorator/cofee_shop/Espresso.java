package ru.edhunter.independent_seatwork.gof_patterns.decorator.cofee_shop;

public class Espresso extends Beverage{
    @Override
    public String getDescription() {
        return "Espresso";
    }

    @Override
    public double cost() {
        return  1.99;
    }
}
