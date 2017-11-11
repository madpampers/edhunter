package ru.edhunter.independent_seatwork.gof_patterns.proxy.project;

public class ProjectRunner {
    public static void main(String[] args) {
        Project project = new ProxyProject("edhunter.ru/project");

        project.run();
    }
}
