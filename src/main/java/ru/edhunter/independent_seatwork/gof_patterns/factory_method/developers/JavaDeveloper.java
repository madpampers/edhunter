package ru.edhunter.independent_seatwork.gof_patterns.factory_method.developers;

public class JavaDeveloper implements Developer{
    @Override
    public void write() {
        System.out.println("writes java code");
    }
}
