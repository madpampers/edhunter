package ru.edhunter.independent_seatwork.gof_patterns.command.smart_home;

public class Stereo {
    private String cd = "";

    private String dvd = "";
    private double radio = 0;
    private int volume = 0;

    public void on() {
        System.out.println("Stereo is on");
    }

    public void off() {
        System.out.println("Stereo is off");
    }

    public void setCd(String cdName) {
        cd = cdName;
        if (!cdName.equals(""))
            System.out.println("current cd is: " + cd);
    }

    public void setDvd(String dvdName) {
        dvd = dvdName;
        if (!dvd.equals(""))
        System.out.println("current dvd is: " + cd);
    }

    public void setRadio(double radio) {
        this.radio = radio;
        if(radio != 0)
        System.out.println("current radio station is: " + radio);
    }

    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("Volume set to " + volume);
    }

    public String getCd() {
        return cd;
    }

    public String getDvd() {
        return dvd;
    }

    public double getRadio() {
        return radio;
    }

    public int getVolume() {
        return volume;
    }

}
