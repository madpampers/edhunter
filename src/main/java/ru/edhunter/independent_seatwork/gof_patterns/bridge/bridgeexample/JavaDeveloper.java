package ru.edhunter.independent_seatwork.gof_patterns.bridge.bridgeexample;

public class JavaDeveloper implements Developer{
    @Override
    public void writeCode() {
        System.out.println("Java developer writes java code...");
    }
}
