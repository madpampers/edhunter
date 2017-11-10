package ru.edhunter.independent_seatwork.gof_patterns.abstract_factory.it_company.banking;

import ru.edhunter.independent_seatwork.gof_patterns.abstract_factory.it_company.Developer;

public class JavaDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("Java developer writes JAVA code");
    }
}
