package ru.edhunter.independent_seatwork.gof_patterns.visitor.visitorexample;

public class ProjectRunner {
    public static void main(String[] args) {
        Project project = new Project();

        Developer jun = new JuniorDeveloper();
        Developer sen = new SeniorDeveloper();

        System.out.println("Junior in action");

        project.beWritten(jun);

        System.out.println("============================");

        System.out.println("Senior in action");

        project.beWritten(sen);
    }
}
