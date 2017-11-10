package ru.edhunter.independent_seatwork.gof_patterns.strategy.activity;

/**
 * Implementation of algorithm
 * */
public class Training implements Activity {
    @Override
    public void justDoIt() {
        System.out.println("Training...");
    }
}
