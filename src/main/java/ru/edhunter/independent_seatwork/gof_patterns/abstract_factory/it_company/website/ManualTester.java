package ru.edhunter.independent_seatwork.gof_patterns.abstract_factory.it_company.website;

import ru.edhunter.independent_seatwork.gof_patterns.abstract_factory.it_company.Tester;

public class ManualTester implements Tester {
    @Override
    public void testCode() {
        System.out.println("Manual tester test php code");
    }
}
