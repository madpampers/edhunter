package ru.edhunter.independent_seatwork.data_bases.sql.jdbc.from_sqlex.computer_company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        System.out.println("Введите имя пользователя:");
        String username = getInput();
        System.out.println("Введите пароль:");
        String password = getInput();
        final User user = new User(username, password);

        final Model model = Model.newInstance(user);
        final View view = new ConsoleView();

        final Controller controller = new Controller(model, view);
        System.out.println("Какие модели отобразить?(pc, laptop, printer)");
        controller.runQuery(getInput().toLowerCase());
    }


    private static String getInput() throws IOException {
        return reader.readLine();
    }
}