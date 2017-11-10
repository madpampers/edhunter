package ru.edhunter.independent_seatwork.gof_patterns.command.smart_home;

public class GarageDoorUpCommand implements Command{
    final private Garage garage;

    public GarageDoorUpCommand(Garage garage) {
        this.garage = garage;
    }

    @Override
    public void execute() {
        garage.doorUp();
    }

    @Override
    public void undo() {
        garage.doorDown();
    }
}
