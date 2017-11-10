package ru.edhunter.independent_seatwork.gof_patterns.facade.facade_example;

public class WorkFlow {
    Developer developer = new Developer();
    Job job = new Job();
    BugTracker bugTracker = new BugTracker();

    public void solveProblems() {
        job.doJob();
        bugTracker.startSprint();
        developer.doJobBewforeDeadline(bugTracker);
    }
}
