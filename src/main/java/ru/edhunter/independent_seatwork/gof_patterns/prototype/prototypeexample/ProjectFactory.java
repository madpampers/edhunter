package ru.edhunter.independent_seatwork.gof_patterns.prototype.prototypeexample;

public class ProjectFactory {
    private Project project;

    public ProjectFactory(Project project) {
        this.project = project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    Project copyProject() {
        return project.copy();
    }
}
