package ru.edhunter.independent_seatwork.gof_patterns.bridge.bridgeexample;

public class StockExchange extends Program {

    protected StockExchange(Developer developer) {
        super(developer);
    }

    @Override
    public void developProgram() {
        System.out.println("StockExchange development in progress");
        developer.writeCode();
    }
}
