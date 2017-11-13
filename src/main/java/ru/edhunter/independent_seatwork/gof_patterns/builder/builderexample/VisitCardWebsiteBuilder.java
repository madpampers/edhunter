package ru.edhunter.independent_seatwork.gof_patterns.builder.builderexample;

import static ru.edhunter.independent_seatwork.gof_patterns.builder.builderexample.Cms.WORDPRESS;

public class VisitCardWebsiteBuilder extends WebsiteBuilder {
    @Override
    void buildName() {
        website.setName("Visitcard");
    }

    @Override
    void buildCms() {
        website.setCms((WORDPRESS));
    }

    @Override
    void buildPrice() {
        website.setPrice(500);
    }
}
