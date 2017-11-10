package ru.edhunter.independent_seatwork.gof_patterns.abstract_factory.it_company;

import ru.edhunter.independent_seatwork.gof_patterns.abstract_factory.it_company.website.WebsiteTeamFactory;

public class AuctionSiteProject {
    public static void main(String[] args) {
        ProjectTeamFactory teamFactory = new WebsiteTeamFactory();
        Developer developer = teamFactory.getDeveloper();
        Tester tester = teamFactory.getTester();
        ProjectManager manager = teamFactory.getProjectManager();

        System.out.println("Creating auction website");
        developer.writeCode();
        tester.testCode();
        manager.manageProject();
    }
}
