package ru.edhunter.independent_seatwork.gof_patterns.observer.headhunter;

import ru.edhunter.independent_seatwork.gof_patterns.observer.headhunter.interfaces.Observer;

public class Main {
    public static void main(String[] args) {
        JavaDeveloperJobsSite javaDeveloperJobsSite = new JavaDeveloperJobsSite();
        javaDeveloperJobsSite.addVacancy("Junior Java Developer");
        javaDeveloperJobsSite.addVacancy("Middle Java Developer");

        Observer firstObserver = new Subscriber("Ivan");
        Observer secondObserver = new Subscriber("Vova");

        javaDeveloperJobsSite.addObserver(firstObserver);
        javaDeveloperJobsSite.addObserver(secondObserver);

        javaDeveloperJobsSite.addVacancy("Senior Java Developer");

        javaDeveloperJobsSite.removeVacancy("Junior Java Developer");
    }
}
