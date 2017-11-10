package ru.edhunter.independent_seatwork.gof_patterns.template_method.website;

public class WelcomePage extends WebsiteTemplate {
    @Override
    protected void showWebContent() {
        System.out.println("Welcome");
    }
}
