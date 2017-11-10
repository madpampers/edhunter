package ru.edhunter.independent_seatwork.gof_patterns.command.smart_home;

public class MacroCommand implements Command {
    final private Command[] commands;

    public MacroCommand(Command[] commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }

    @Override
    public void undo() {

    }
}
