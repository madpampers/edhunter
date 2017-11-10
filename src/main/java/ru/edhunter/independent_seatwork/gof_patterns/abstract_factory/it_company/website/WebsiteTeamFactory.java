package ru.edhunter.independent_seatwork.gof_patterns.abstract_factory.it_company.website;

import ru.edhunter.independent_seatwork.gof_patterns.abstract_factory.it_company.Developer;
import ru.edhunter.independent_seatwork.gof_patterns.abstract_factory.it_company.ProjectManager;
import ru.edhunter.independent_seatwork.gof_patterns.abstract_factory.it_company.ProjectTeamFactory;
import ru.edhunter.independent_seatwork.gof_patterns.abstract_factory.it_company.Tester;

public class WebsiteTeamFactory implements ProjectTeamFactory {
    @Override
    public Developer getDeveloper() {
        return new PhpDeveloper();
    }

    @Override
    public Tester getTester() {
        return new ManualTester();
    }

    @Override
    public ProjectManager getProjectManager() {
        return new WebsitePMManager();
    }
}
