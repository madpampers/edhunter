package ru.edhunter.independent_seatwork.gof_patterns.command.smart_home;

public class StereoOffCommand implements Command {
    final private Stereo stereo;
    private String previousStereoCd;
    private String previousStereoDvd;
    private double previousStereoRadio;
    private int previousStereoVolume;

    public StereoOffCommand(Stereo stereo) {
        this.stereo = stereo;
    }


    @Override
    public void execute() {
        previousStereoCd = stereo.getCd();
        previousStereoDvd = stereo.getDvd();
        previousStereoRadio = stereo.getRadio();
        previousStereoVolume = stereo.getVolume();
        stereo.off();
    }

    @Override
    public void undo() {
        stereo.on();
        stereo.setCd(previousStereoCd);
        stereo.setDvd(previousStereoDvd);
        stereo.setRadio(previousStereoRadio);
        stereo.setVolume(previousStereoVolume);
    }
}
