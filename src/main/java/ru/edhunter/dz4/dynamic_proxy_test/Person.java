package ru.edhunter.dz4.dynamic_proxy_test;

import ru.edhunter.dz4.dynamic_proxy_test.interfaces.*;

public class Person implements IRun, IWork, IFly, ISwim{
    @Override
    public void fly() {
    }

    @Override
    public void run() {
    }

    @Override
    public void swim() {
    }

    @Override
    public void work() {
    }
}
