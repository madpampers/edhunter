package ru.edhunter.independent_seatwork.gof_patterns.command.smart_home;

public class StereoOnWithCDCommand implements Command{
    final private Stereo stereo;

    public StereoOnWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }


    @Override
    public void execute() {
        stereo.on();
        stereo.setCd("default disk");
        stereo.setVolume(11);
    }

    @Override
    public void undo() {
        stereo.off();
    }
}
