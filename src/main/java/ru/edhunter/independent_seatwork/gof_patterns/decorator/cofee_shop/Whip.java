package ru.edhunter.independent_seatwork.gof_patterns.decorator.cofee_shop;

public class Whip extends CondimentDecorator {
    final private Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        return 0.15 + beverage.cost();
    }
}
