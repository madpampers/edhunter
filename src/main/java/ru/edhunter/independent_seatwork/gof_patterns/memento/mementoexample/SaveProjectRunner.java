package ru.edhunter.independent_seatwork.gof_patterns.memento.mementoexample;

public class SaveProjectRunner {
    public static void main(String[] args) throws InterruptedException {
        Project project = new Project();
        GitHubRepo gitHubRepo = new GitHubRepo();

        System.out.println("Creating project, version 1.0");
        System.out.println();
        Thread.sleep(2000);
        project.setDateAndVersion("Version 1.0");
        System.out.println();

        System.out.println(project);

        System.out.println("Saving project");
        Thread.sleep(2000);
        System.out.println();

        gitHubRepo.setSave(project.save());

        System.out.println("Updating project to version 1.1");
        Thread.sleep(2000);
        System.out.println();

        project.setDateAndVersion("Version 1.1");
        Thread.sleep(2000);
        System.out.println();
        System.out.println(project);

        System.out.println("Something went wrong, need to load");
        Thread.sleep(2000);
        System.out.println();
        System.out.println("Loading project");
        Thread.sleep(2000);
        System.out.println();

        project.load(gitHubRepo.getSave());

        System.out.println("Loaded previous version");
        Thread.sleep(2000);
        System.out.println();
        System.out.println(project);
    }
}
