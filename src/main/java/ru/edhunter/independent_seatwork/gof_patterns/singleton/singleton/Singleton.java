package ru.edhunter.independent_seatwork.gof_patterns.singleton.singleton;

public class Singleton {
    final private static Singleton singleton = new Singleton();
    private Singleton(){}
    public static Singleton getInstance() {
        return singleton;
    }
}
