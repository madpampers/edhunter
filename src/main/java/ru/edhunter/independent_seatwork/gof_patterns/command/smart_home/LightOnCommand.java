package ru.edhunter.independent_seatwork.gof_patterns.command.smart_home;

public class LightOnCommand implements Command{
    final private Light light;

    public LightOnCommand(Light light){
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
