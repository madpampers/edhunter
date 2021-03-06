package ru.edhunter.independent_seatwork.gof_patterns.abstract_factory.it_company;

public interface ProjectTeamFactory {
    Developer getDeveloper();
    Tester getTester();
    ProjectManager getProjectManager();
}
