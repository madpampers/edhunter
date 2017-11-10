package ru.edhunter.independent_seatwork.gof_patterns.facade.facade_example;

public class Developer {
    public void doJobBewforeDeadline(BugTracker bugTracker){
        if(bugTracker.isActiveSprint()) {
            System.out.println("Developer solves problems");
        } else {
            System.out.println("Developer reads habr");
        }
    }
}
