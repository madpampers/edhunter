package ru.edhunter.independent_seatwork.gof_patterns.abstract_factory.it_company;

import ru.edhunter.independent_seatwork.gof_patterns.abstract_factory.it_company.banking.BankingTeamFactory;

public class SuperBankSystem {
    public static void main(String[] args) {
        ProjectTeamFactory teamFactory = new BankingTeamFactory();
        Developer developer = teamFactory.getDeveloper();
        Tester tester = teamFactory.getTester();
        ProjectManager manager = teamFactory.getProjectManager();

        System.out.println("Creating bank system");

        developer.writeCode();
        tester.testCode();
        manager.manageProject();
    }
}
