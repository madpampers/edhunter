package ru.edhunter.independent_seatwork.gof_patterns.factory_method.developers;

public class PhpDeveloperFactory implements DeveloperFactory {
    @Override
    public Developer createDeveloper() {
        return new PhpDeveloper();
    }
}
