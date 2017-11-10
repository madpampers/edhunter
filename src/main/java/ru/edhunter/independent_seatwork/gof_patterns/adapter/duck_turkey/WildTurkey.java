package ru.edhunter.independent_seatwork.gof_patterns.adapter.duck_turkey;

public class WildTurkey implements Turkey{
    @Override
    public void gobble() {
        System.out.println("Gobble gobble!..");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying a short distance");
    }
}
