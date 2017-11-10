package ru.edhunter.independent_seatwork.gof_patterns.decorator.developer;

public class JavaDeveloper implements Developer {
    @Override
    public String makeJob() {
        return "Write Code";
    }
}
