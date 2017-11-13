package ru.edhunter.independent_seatwork.gof_patterns.state.state_example;

public class Sleeping implements Activity {
    @Override
    public void justDoIt() {
        System.out.println("sleeping...");
    }
}
