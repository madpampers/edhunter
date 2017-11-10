package ru.edhunter.independent_seatwork.gof_patterns.factory_method.developers;

public class PhpDeveloper implements Developer {
    @Override
    public void write() {
        System.out.println("writes php code");
    }
}
