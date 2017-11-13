package ru.edhunter.independent_seatwork.gof_patterns.bridge.bridgeexample;

public class CppDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("Cpp developer writes cpp code...");
    }
}
