package ru.edhunter.independent_seatwork.gof_patterns.command.smart_home;

public class TestSimpleRemote {
    public static void main(String[] args) {
        SimpleRemoteControl simpleRemote = new SimpleRemoteControl();
        Light light = new Light("Кухня");

        simpleRemote.setCommand(new LightOnCommand(light));
        simpleRemote.buttonPress();

        simpleRemote.setCommand(new LightOffCommand(light));
        simpleRemote.buttonPress();
    }
}
