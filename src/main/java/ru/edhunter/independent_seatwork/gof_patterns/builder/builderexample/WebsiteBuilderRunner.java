package ru.edhunter.independent_seatwork.gof_patterns.builder.builderexample;

public class WebsiteBuilderRunner {
    public static void main(String[] args) {
        Director director = new Director();

        director.setBuilder(new EnterpriseWebsiteBuilder());
        Website website = director.buildWebsite();

        System.out.println(website);
    }
}
