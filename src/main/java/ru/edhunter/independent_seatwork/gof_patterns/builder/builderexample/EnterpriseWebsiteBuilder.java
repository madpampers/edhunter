package ru.edhunter.independent_seatwork.gof_patterns.builder.builderexample;

import static ru.edhunter.independent_seatwork.gof_patterns.builder.builderexample.Cms.ALIFRESCO;

public class EnterpriseWebsiteBuilder extends WebsiteBuilder{
    @Override
    void buildName() {
        website.setName("Enterprise site");
    }

    @Override
    void buildCms() {
        website.setCms(ALIFRESCO);
    }

    @Override
    void buildPrice() {
        website.setPrice(1000);
    }
}
