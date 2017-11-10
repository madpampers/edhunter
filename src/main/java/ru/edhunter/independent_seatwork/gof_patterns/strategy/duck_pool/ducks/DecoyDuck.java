package ru.edhunter.independent_seatwork.gof_patterns.strategy.duck_pool.ducks;

/**
 *Just a duck, can fly and quack
 * */
public class DecoyDuck extends Duck {
    @Override
    public void display() {
        System.out.println("Decoy duck shows!");
    }
}
