package ru.edhunter.independent_seatwork.gof_patterns.template_method.website;

public abstract class WebsiteTemplate {
    final public void showPage() {
        System.out.println("Header");
        showWebContent();
        System.out.println("Footer");
    }
    protected abstract void showWebContent();
}
