package ru.edhunter.independent_seatwork.gof_patterns.decorator.developer;

public class DeveloperDecorator implements Developer{
    final private Developer developer;

    public DeveloperDecorator(Developer developer) {
        this.developer = developer;
    }

    @Override
    public String makeJob() {
        return developer.makeJob();
    }
}
