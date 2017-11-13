package ru.edhunter.independent_seatwork.gof_patterns.mediator.mediatorexample;

public class Admin implements User {
    Chat chat;
    String name;

    public Admin(Chat chat, String name) {
        this.chat = chat;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void sendMsg(String message) {
        chat.sendMsg(message, this);
    }

    @Override
    public void getMsg(String message) {
        System.out.println(this.name+ " recieve message " + message);
    }
}
