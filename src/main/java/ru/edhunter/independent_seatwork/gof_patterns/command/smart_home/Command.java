package ru.edhunter.independent_seatwork.gof_patterns.command.smart_home;

public interface Command {
    void execute();
    void undo();
}
