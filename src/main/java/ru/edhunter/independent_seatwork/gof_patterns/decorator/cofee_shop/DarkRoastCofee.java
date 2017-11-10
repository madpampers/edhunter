package ru.edhunter.independent_seatwork.gof_patterns.decorator.cofee_shop;

public class DarkRoastCofee extends Beverage {
    @Override
    public String getDescription() {
        return "Dark Roast Cofee";
    }

    @Override
    public double cost() {
        return 1.00;
    }
}
