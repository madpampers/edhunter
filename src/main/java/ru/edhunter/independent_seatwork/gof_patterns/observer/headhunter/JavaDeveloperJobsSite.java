package ru.edhunter.independent_seatwork.gof_patterns.observer.headhunter;

import ru.edhunter.independent_seatwork.gof_patterns.observer.headhunter.interfaces.Observer;
import ru.edhunter.independent_seatwork.gof_patterns.observer.headhunter.interfaces.Subject;

import java.util.ArrayList;
import java.util.List;

public class JavaDeveloperJobsSite implements Subject{
    List<String> vacancies = new ArrayList<>();
    List<Observer> observers = new ArrayList<>();

    public void addVacancy (String vacancy) {
        vacancies.add(vacancy);
        notifyObservers();
    }

    public void removeVacancy(String vacancy) {
        vacancies.remove(vacancy);
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(vacancies);
        }
    }
}
