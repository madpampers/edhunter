package ru.edhunter.independent_seatwork.gof_patterns.decorator.cofee_shop;

public class Soy extends CondimentDecorator{
    final private Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+ ", Soy";
    }

    @Override
    public double cost() {
        return 0.10 + beverage.cost();
    }
}
