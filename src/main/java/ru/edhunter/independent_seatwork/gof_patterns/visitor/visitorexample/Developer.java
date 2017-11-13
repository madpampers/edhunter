package ru.edhunter.independent_seatwork.gof_patterns.visitor.visitorexample;

public interface Developer {
    void create(ProjectClass projectClass);
    void create(Database database);
    void create(Test test);
}
