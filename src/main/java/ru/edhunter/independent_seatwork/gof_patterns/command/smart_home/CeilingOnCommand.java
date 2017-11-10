package ru.edhunter.independent_seatwork.gof_patterns.command.smart_home;

public class CeilingOnCommand implements Command{
    final private Ceiling ceiling;

    public CeilingOnCommand(Ceiling ceiling) {
        this.ceiling = ceiling;
    }

    @Override
    public void execute() {
        ceiling.on();
    }

    @Override
    public void undo() {
        ceiling.off();
    }
}
