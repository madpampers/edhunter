package ru.edhunter.dz4.dynamic_proxy_test;

import ru.edhunter.dz4.dynamic_proxy_test.interfaces.*;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        Object proxyPerson = Proxy.newProxyInstance(Person.class.getClassLoader(), person.getClass().getInterfaces(), new Logger(person));
        final Class<?> aClass = proxyPerson.getClass();
        Class[] interfaces = aClass.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface.getSimpleName());
        }

        System.out.println();

        ((IFly) proxyPerson).fly();
        ((IRun) proxyPerson).run();
        ((IWork) proxyPerson).work();
        ((ISwim) proxyPerson).swim();

        System.out.println();

        System.out.println(proxyPerson.getClass().getName());
    }
}
