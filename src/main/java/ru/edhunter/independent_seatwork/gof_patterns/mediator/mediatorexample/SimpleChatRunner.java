package ru.edhunter.independent_seatwork.gof_patterns.mediator.mediatorexample;

public class SimpleChatRunner {
    public static void main(String[] args) {
        SimpleTextChat chat = new SimpleTextChat();
        User admin = new Admin(chat,"Admin");
        User user1 = new Admin(chat,"User1");
        User user2 = new Admin(chat,"User2");

        chat.setAdmin(admin);
        chat.addUserToChat(user1);
        chat.addUserToChat(user2);

        user1.sendMsg("Hello!");
        admin.sendMsg("Hello, I am admin");
    }
}
