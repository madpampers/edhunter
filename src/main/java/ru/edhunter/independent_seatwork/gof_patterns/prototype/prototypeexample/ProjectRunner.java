package ru.edhunter.independent_seatwork.gof_patterns.prototype.prototypeexample;

public class ProjectRunner {
    public static void main(String[] args) {
        Project master= new Project(1,"Super", "source code of project");

        System.out.println(master);

        ProjectFactory projectFactory = new ProjectFactory(master);

        Project copyOfMaster = master.copy();
        System.out.println(copyOfMaster);

        Project anotherClone = projectFactory.copyProject();
        System.out.println(anotherClone);
    }
}
