package com.tryton.adv.server.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@SpringBootTest
class DbBasedAdvertisementServiceIntegrationTest {

    private static final String DATA_SOURCE = "Google Ads";
    private static final LocalDate START_DATE = LocalDate.of(2019, 3, 3);

    @Autowired
    private DbBasedAdvertisementService dbBasedAdvertisementService;

    @Test
    void geTotalClicks() {
        //given
        Optional<LocalDate> endDateOptional = Optional.of(LocalDate.of(2019, 3, 4));

        //when
        long totalClicks = dbBasedAdvertisementService.geTotalClicks(DATA_SOURCE, START_DATE, endDateOptional);

        //then
        assertThat(totalClicks).isEqualTo(583);
    }

    @Test
    void getClickThroughRate() {
        //given
        String campaign = "Adventmarkt Touristik";

        //when
        long clickThroughRate = dbBasedAdvertisementService.getClickThroughRate(DATA_SOURCE, campaign);

        //then
        assertThat(clickThroughRate).isEqualTo(4793);
    }

    @Test
    void getImpressions() {
        //given-when
        long impressions = dbBasedAdvertisementService.getImpressions(START_DATE);

        //then
        assertThat(impressions).isEqualTo(60193);
    }
}
