package ru.edhunter.independent_seatwork.gof_patterns.bridge.bridgeexample;

public class ProgramCreator {
    public static void main(String[] args) {
        Program[] programs = {
                new BankSystem(new CppDeveloper()),
                new StockExchange(new CppDeveloper())
        };
        for (Program program : programs) {
            program.developProgram();
        }
    }
}
