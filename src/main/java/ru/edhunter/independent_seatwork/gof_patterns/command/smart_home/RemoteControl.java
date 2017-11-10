package ru.edhunter.independent_seatwork.gof_patterns.command.smart_home;

public class RemoteControl {
    private Command[] onCommands;
    private Command[] offCommands;
    private Command undoButton;

    public RemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];

        Command noCommand = new NoCommand();

        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }

        undoButton = noCommand;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void buttonOnPresses(int slot) {
        onCommands[slot].execute();
        undoButton = onCommands[slot];
    }

    public void buttonOffPresses(int slot) {
        offCommands[slot].execute();
        undoButton = offCommands[slot];
    }

    public void undoButtonPresses() {
        undoButton.undo();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            stringBuilder.append(onCommands[i]).append("        ").append(offCommands[i]).append("\n");

        }
        return stringBuilder.toString();
    }
}
