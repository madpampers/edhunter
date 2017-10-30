package ru.edhunter.independent_seatwork.data_bases.sql.jdbc.from_sqlex.computer_company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ConsoleView extends View {
    @Override
    protected void printQuery(List<String> products) {
        for (String product : products) {
            System.out.println(product);
        }
    }
}
