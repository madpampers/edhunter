package ru.edhunter.independent_seatwork.gof_patterns.command.smart_home;

public class GarageDoorDownCommand implements Command{
    final private Garage garage;

    public GarageDoorDownCommand(Garage garage) {
        this.garage = garage;
    }

    @Override
    public void execute() {
        garage.doorDown();
    }

    @Override
    public void undo() {
        garage.doorUp();
    }
}
