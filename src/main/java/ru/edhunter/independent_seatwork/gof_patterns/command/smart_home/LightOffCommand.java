package ru.edhunter.independent_seatwork.gof_patterns.command.smart_home;

public class LightOffCommand implements Command{
    final private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
