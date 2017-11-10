package ru.edhunter.independent_seatwork.gof_patterns.observer.headhunter.interfaces;

import java.util.List;

public interface Observer {
    void update(List<String> vacancies);
}
