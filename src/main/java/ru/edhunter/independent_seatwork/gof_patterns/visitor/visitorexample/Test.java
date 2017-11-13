package ru.edhunter.independent_seatwork.gof_patterns.visitor.visitorexample;

public class Test implements ProjectElement {
    @Override
    public void beWritten(Developer developer) {
        developer.create(this);
    }
}
