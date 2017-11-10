package ru.edhunter.independent_seatwork.gof_patterns.observer.headhunter;

import ru.edhunter.independent_seatwork.gof_patterns.observer.headhunter.interfaces.Observer;

import java.util.List;

public class Subscriber implements Observer {
    String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(List<String> vacancies) {
        System.out.println("Dear " + name + "! \n We have some changes in vacancies!\n" + vacancies
                +"\n===========================================\n");
    }


}
