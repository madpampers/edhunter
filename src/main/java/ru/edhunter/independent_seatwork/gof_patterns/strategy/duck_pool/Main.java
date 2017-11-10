package ru.edhunter.independent_seatwork.gof_patterns.strategy.duck_pool;

import ru.edhunter.independent_seatwork.gof_patterns.strategy.duck_pool.behaviors.fly_behaviors.FlyNoWay;
import ru.edhunter.independent_seatwork.gof_patterns.strategy.duck_pool.behaviors.fly_behaviors.FlyWithWings;
import ru.edhunter.independent_seatwork.gof_patterns.strategy.duck_pool.behaviors.quack_behaviors.Quack;
import ru.edhunter.independent_seatwork.gof_patterns.strategy.duck_pool.behaviors.quack_behaviors.Squeak;
import ru.edhunter.independent_seatwork.gof_patterns.strategy.duck_pool.ducks.Duck;
import ru.edhunter.independent_seatwork.gof_patterns.strategy.duck_pool.ducks.MallardDuck;
import ru.edhunter.independent_seatwork.gof_patterns.strategy.duck_pool.ducks.RedheadDuck;
import ru.edhunter.independent_seatwork.gof_patterns.strategy.duck_pool.ducks.RubberDuck;

import java.util.ArrayList;
import java.util.List;
/**
 * Test class
 * */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Duck rubberDuck = new RubberDuck();
        rubberDuck.setFlyBehavior(new FlyNoWay());
        rubberDuck.setQuackBehavior(new Squeak());

        Duck mallardDuck = new MallardDuck();
        mallardDuck.setFlyBehavior(new FlyWithWings());
        mallardDuck.setQuackBehavior(new Quack());

        Duck redheadDuck = new RedheadDuck();
        redheadDuck.setFlyBehavior(new FlyWithWings());
        redheadDuck.setQuackBehavior(new Quack());

        List<Duck> listOfDucks = new ArrayList<>();

        listOfDucks.add(redheadDuck);
        listOfDucks.add(mallardDuck);
        listOfDucks.add(rubberDuck);

        for (Duck duck : listOfDucks) {
            duck.display();
            Thread.sleep(1000);
            duck.swim();
            Thread.sleep(1000);
            duck.performQuack();
            Thread.sleep(1000);
            duck.performFly();
            Thread.sleep(1000);
            System.out.println("\n\n\n");
        }

        rubberDuck.display();
        rubberDuck.setFlyBehavior(new FlyWithWings());
        rubberDuck.performFly();
        System.out.println("OMG! Rubber duck can fly!!!");
    }
}
