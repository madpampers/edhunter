package ru.edhunter.independent_seatwork.gof_patterns.bridge.bridgeexample;

public abstract class Program {
    protected Developer developer;

    protected Program(Developer developer) {
        this.developer = developer;
    }

    public abstract void developProgram();
}
