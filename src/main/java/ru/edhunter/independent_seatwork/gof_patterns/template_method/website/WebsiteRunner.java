package ru.edhunter.independent_seatwork.gof_patterns.template_method.website;

public class WebsiteRunner {
    public static void main(String[] args) {
        WebsiteTemplate welcomePage = new WelcomePage();
        WebsiteTemplate newsPage = new NewsPage();

        welcomePage.showPage();
        System.out.println("============");
        newsPage.showPage();
    }
}
