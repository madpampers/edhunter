package ru.edhunter.independent_seatwork.gof_patterns.command.smart_home;

public class TestRemoteControl {
    public static void main(String[] args) {
        Light livingRoomLigth = new Light("Living room");
        Light kitchenLight = new Light("Kitchen");
        Garage garage = new Garage();
        Ceiling ceiling = new Ceiling();
        Stereo stereo = new Stereo();

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(0, new LightOnCommand(livingRoomLigth), new LightOffCommand(livingRoomLigth));
        remoteControl.setCommand(1, new LightOnCommand(kitchenLight), new LightOffCommand(kitchenLight));
        remoteControl.setCommand(2, new CeilingOnCommand(ceiling), new CeilingOffCommand(ceiling));
        remoteControl.setCommand(3, new GarageDoorUpCommand(garage), new GarageDoorDownCommand(garage));
        remoteControl.setCommand(4, new StereoOnWithCDCommand(stereo), new StereoOffCommand(stereo));
        remoteControl.setCommand(5,
                new MacroCommand(new Command[]{
                        new LightOnCommand(livingRoomLigth),
                        new LightOnCommand(kitchenLight),
                        new CeilingOnCommand(ceiling),
                        new GarageDoorUpCommand(garage),
                        new StereoOnWithCDCommand(stereo)}),
                new MacroCommand(new Command[]{new LightOffCommand(livingRoomLigth),
                        new LightOffCommand(kitchenLight),
                        new CeilingOffCommand(ceiling),
                        new GarageDoorDownCommand(garage),
                        new StereoOffCommand(stereo)}));

        System.out.println(remoteControl);

        System.out.println();

//        remoteControl.buttonOnPresses(0);
//        remoteControl.buttonOnPresses(1);
//        remoteControl.undoButtonPresses();
//        remoteControl.buttonOnPresses(2);
//        remoteControl.buttonOnPresses(3);
//        remoteControl.buttonOnPresses(4);
//        remoteControl.undoButtonPresses();
        remoteControl.buttonOnPresses(5);

        System.out.println();

//        remoteControl.buttonOffPresses(4);
//        remoteControl.undoButtonPresses();
//        remoteControl.buttonOffPresses(3);
//        remoteControl.buttonOffPresses(2);
//        remoteControl.buttonOffPresses(1);
//        remoteControl.buttonOffPresses(0);
        remoteControl.buttonOffPresses(5);
    }
}
