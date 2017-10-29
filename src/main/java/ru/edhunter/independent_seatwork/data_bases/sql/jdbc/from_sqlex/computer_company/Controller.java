package ru.edhunter.independent_seatwork.data_bases.sql.jdbc.from_sqlex.computer_company;

import java.sql.ResultSet;
import java.util.List;

class Controller {
    private final Model model;
    private final View view;

    Controller(final Model model, final View view) {
        this.model = model;
        this.view = view;
    }

    void runQuery(String s) {
        if (!s.equals("pc") && !s.equals("laptop") && !s.equals("printer")) {
            System.out.println("Такого товара нет");
        } else {
            List<String> productModels = model.doQuery("select model from " + s);
            view.showQuery(productModels);
        }
    }
}
