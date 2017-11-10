package ru.edhunter.independent_seatwork.gof_patterns.decorator.developer;

public class SeniorJavaDeveloper extends DeveloperDecorator {
    public SeniorJavaDeveloper(Developer developer) {
        super(developer);
    }

    public String makeCodeReview() {
        return " Make codereview";
    }

    @Override
    public String makeJob() {
        return super.makeJob() + makeCodeReview();
    }
}
