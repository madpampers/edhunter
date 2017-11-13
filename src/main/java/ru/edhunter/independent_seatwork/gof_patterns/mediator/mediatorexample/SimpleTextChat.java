package ru.edhunter.independent_seatwork.gof_patterns.mediator.mediatorexample;

import java.util.ArrayList;
import java.util.List;

public class SimpleTextChat implements Chat {
    User admin;
    List<User> users = new ArrayList<>();

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public void addUserToChat(User user){
        users.add(user);
    }

    @Override
    public void sendMsg(String message, User user) {
        for (User user1 : users) {
            if(user1!= user){
                user1.getMsg(message);
            }
        }
        admin.getMsg(message);
    }
}
