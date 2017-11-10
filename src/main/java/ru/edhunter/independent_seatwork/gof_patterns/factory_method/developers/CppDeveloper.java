package ru.edhunter.independent_seatwork.gof_patterns.factory_method.developers;

public class CppDeveloper implements Developer {
    @Override
    public void write() {
        System.out.println("writes cpp code");
    }
}
