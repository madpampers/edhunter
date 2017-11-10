package ru.edhunter.independent_seatwork.gof_patterns.command.smart_home;

public class SimpleRemoteControl {
    private Command slot;

    public void setCommand(Command command) {
        this.slot = command;
    }

    public void buttonPress() {
        slot.execute();
    }
}
