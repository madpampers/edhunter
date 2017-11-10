package ru.edhunter.independent_seatwork.gof_patterns.decorator.cofee_shop;

public class HouseBlend extends Beverage{
    @Override
    public String getDescription() {
        return "House Blend Cofee";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
