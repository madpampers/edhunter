package ru.edhunter.independent_seatwork.gof_patterns.command.smart_home;

public class CeilingOffCommand implements Command{
    final private Ceiling ceiling;

    public CeilingOffCommand(Ceiling ceiling) {
        this.ceiling = ceiling;
    }

    @Override
    public void execute() {
        ceiling.off();
    }

    @Override
    public void undo() {
        ceiling.on();
    }
}
