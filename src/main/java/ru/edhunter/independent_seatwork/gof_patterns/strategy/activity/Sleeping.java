package ru.edhunter.independent_seatwork.gof_patterns.strategy.activity;

/**
 * Implementation of algorithm
 * */
public class Sleeping implements Activity {
    @Override
    public void justDoIt() {
        System.out.println("Sleeping...");
    }
}
