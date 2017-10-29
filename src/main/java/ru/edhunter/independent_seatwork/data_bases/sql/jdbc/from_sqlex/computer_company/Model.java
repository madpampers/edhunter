package ru.edhunter.independent_seatwork.data_bases.sql.jdbc.from_sqlex.computer_company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Model {
    private final String url = "jdbc:postgresql://localhost:5432/computer_firm";
    private final String user;
    private final String password;

    private Model(String user, String password) {
        this.user = user;
        this.password = password;
    }

    private void initTables() {
        String deleteRawFromTablesStatements[] = {
                "DELETE FROM pc",
                "DELETE FROM laptop",
                "DELETE FROM product",
                "DELETE FROM printer"
        };
        String copyPCQuery = "COPY pc (model, speed, ram, hd, cd, price)FROM 'E:\\IDEA\\edhunter\\src\\main\\resources\\pc_raws.csv' CSV;";
        String copyLaptopQuery = "COPY laptop (model, speed, ram, hd, price, screen)FROM 'E:\\IDEA\\edhunter\\src\\main\\resources\\laptop_raws.csv' CSV;";
        String copyPrinterQuery = "COPY printer (model, color, type, price)FROM 'E:\\IDEA\\edhunter\\src\\main\\resources\\printer_raws.csv' CSV;";
        String copyProductQuery = "COPY product (maker, model, type)FROM product_raws.csv CSV;";


        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {

            for (int i = 0; i < 4; i++) {
                statement.addBatch(deleteRawFromTablesStatements[i]);
            }

            statement.addBatch(copyLaptopQuery);
            statement.addBatch(copyPCQuery);
            statement.addBatch(copyPrinterQuery);
            statement.addBatch(copyProductQuery);
            statement.executeBatch();
            System.out.println("База данных инициализирована");


        } catch (SQLException e) {
            if (e.getSQLState().equals("28000")) {
                System.out.println("Неправильные данные пользователя");
            }
        }
    }


    public static Model newInstance(final User user) {
        final Model model = new Model(user.getUserName(), user.getUserPassword());
        model.initTables();
        return model;
    }

    public List<String> doQuery(String s) {
        final List<String> productModels = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(s);
            while (resultSet.next()) {
                productModels.add(resultSet.getString("model"));
            }

        } catch (SQLException e) {
            System.out.println("bla");
        }
        return productModels;
    }
}
