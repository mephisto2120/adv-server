package com.tryton.adv.server.dataprovider.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@ActiveProfiles("test")
@SpringBootTest
class AdvertisementMapperIntegrationTest {

    private static final String DATA_SOURCE = "Google Ads";
    private static final Date START_DATE = new Date(1L);

    @Autowired
    private AdvertisementMapper advertisementMapper;

    @Test
    void shouldCheckSyntaxWhenGetImpressions() {
        //given
        Date daily = new Date(3L);

        //when
        Throwable thrown = catchThrowable(() -> advertisementMapper.getImpressions(daily));

        //then
        assertThat(thrown).isNull();
    }

    @Test
    void shouldCheckSyntaxWhenGetClickThroughRate() {
        //given
        String campaign = "Touristik City Guide_Android";

        //when
        Throwable thrown = catchThrowable(() -> advertisementMapper.getClickThroughRate(DATA_SOURCE, campaign));

        //then
        assertThat(thrown).isNull();
    }

    @Test
    void shouldCheckSyntaxWhenGeTotalClicks() {
        //given
        Date endDate = new Date(2L);

        //when
        Throwable thrown = catchThrowable(() -> advertisementMapper.geTotalClicks(DATA_SOURCE, START_DATE, endDate));

        //then
        assertThat(thrown).isNull();
    }

    @Test
    void shouldCheckSyntaxWhenGeTotalClicksAndEndDateNotGiven() {
        //given-when
        Throwable thrown = catchThrowable(() -> advertisementMapper.geTotalClicks(DATA_SOURCE, START_DATE, null));

        //then
        assertThat(thrown).isNull();
    }
}
