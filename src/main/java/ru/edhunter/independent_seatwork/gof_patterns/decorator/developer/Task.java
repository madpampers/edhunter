package ru.edhunter.independent_seatwork.gof_patterns.decorator.developer;

public class Task {
    public static void main(String[] args) {
        Developer developer = new JavaDeveloper();
        System.out.println(developer.makeJob());

        Developer developer1 = new SeniorJavaDeveloper(developer);
        System.out.println(developer1.makeJob());

        Developer developer2 = new JavaTeamLead(developer1);
        System.out.println(developer2.makeJob());
    }
}
