package ru.edhunter.independent_seatwork.gof_patterns.command.smart_home;

public class Light {
    final private String name;

    public Light(String name) {
        this.name = name;
    }

    public void on() {
        System.out.println("Light in " + name + " is on");
    }

    public void off() {
        System.out.println("Light in " + name + " is off");
    }
}
