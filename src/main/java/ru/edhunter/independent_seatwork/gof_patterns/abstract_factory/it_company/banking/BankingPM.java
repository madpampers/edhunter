package ru.edhunter.independent_seatwork.gof_patterns.abstract_factory.it_company.banking;

import ru.edhunter.independent_seatwork.gof_patterns.abstract_factory.it_company.ProjectManager;

public class BankingPM implements ProjectManager {
    @Override
    public void manageProject() {
        System.out.println("BankingPM manages banking project");
    }
}
