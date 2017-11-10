package ru.edhunter.independent_seatwork.gof_patterns.observer.headhunter.interfaces;

public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
