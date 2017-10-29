package ru.edhunter.independent_seatwork.data_bases.sql.jdbc.from_sqlex.computer_company;

public class User {
    private final String userName;
    private final String userPassword;

    public User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }
}
