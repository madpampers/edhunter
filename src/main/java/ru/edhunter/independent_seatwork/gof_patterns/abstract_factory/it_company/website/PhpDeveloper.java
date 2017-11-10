package ru.edhunter.independent_seatwork.gof_patterns.abstract_factory.it_company.website;

import ru.edhunter.independent_seatwork.gof_patterns.abstract_factory.it_company.Developer;

public class PhpDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("Phh developer writes php code");
    }
}
