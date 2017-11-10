package ru.edhunter.independent_seatwork.gof_patterns.abstract_factory.it_company.banking;

import ru.edhunter.independent_seatwork.gof_patterns.abstract_factory.it_company.Tester;

public class QATester implements Tester {
    @Override
    public void testCode() {
        System.out.println("QATester tests banking code");
    }
}
