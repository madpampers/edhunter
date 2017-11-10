package ru.edhunter.independent_seatwork.gof_patterns.adapter.duck_turkey;

public class TurkeyAdapter implements Duck{
    final private Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }


    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        for (int i = 0; i < 3; i++) {
            turkey.fly();
        }
    }

    @Override
    public void swim() {
        throw new UnsupportedOperationException("Turkey cannot swim at all...");
    }
}
