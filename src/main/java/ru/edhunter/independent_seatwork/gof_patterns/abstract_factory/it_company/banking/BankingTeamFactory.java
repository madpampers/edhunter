package ru.edhunter.independent_seatwork.gof_patterns.abstract_factory.it_company.banking;

import ru.edhunter.independent_seatwork.gof_patterns.abstract_factory.it_company.Developer;
import ru.edhunter.independent_seatwork.gof_patterns.abstract_factory.it_company.ProjectManager;
import ru.edhunter.independent_seatwork.gof_patterns.abstract_factory.it_company.ProjectTeamFactory;
import ru.edhunter.independent_seatwork.gof_patterns.abstract_factory.it_company.Tester;

public class BankingTeamFactory implements ProjectTeamFactory {
    @Override
    public Developer getDeveloper() {
        return new JavaDeveloper();
    }

    @Override
    public Tester getTester() {
        return new QATester();
    }

    @Override
    public ProjectManager getProjectManager() {
        return new BankingPM();
    }
}
