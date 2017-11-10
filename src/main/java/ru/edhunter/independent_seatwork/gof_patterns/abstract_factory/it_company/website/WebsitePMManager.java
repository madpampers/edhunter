package ru.edhunter.independent_seatwork.gof_patterns.abstract_factory.it_company.website;

import ru.edhunter.independent_seatwork.gof_patterns.abstract_factory.it_company.ProjectManager;

public class WebsitePMManager implements ProjectManager {
    @Override
    public void manageProject() {
        System.out.println("WebsitePM manages website project");
    }
}
