package ru.edhunter.independent_seatwork.gof_patterns.adapter.duck_turkey;

public class TestDrive {
    public static void main(String[] args) {
        Turkey turkey = new WildTurkey();
        TurkeyAdapter duckTurkey = new TurkeyAdapter(turkey);
        duckTurkey.fly();
        duckTurkey.quack();
        duckTurkey.swim();
    }
}
