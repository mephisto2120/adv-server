package com.tryton.adv.server.controller;

import com.tryton.adv.server.service.AdvertisementService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
public class AdvertisementControllerTest {

    private static final String DATA_SOURCE = "Facebook Ads";
    private static final LocalDate START_DATE = LocalDate.of(2019, 3, 3);

    @Mock
    private AdvertisementService advertisementServiceMock;

    @InjectMocks
    private AdvertisementController advertisementController;

    @Test
    void geTotalClicks() {
        Optional<LocalDate> endDateOptional = Optional.of(LocalDate.of(2019, 3, 4));
        long expectedTotalCLicks = 10_000L;
        given(advertisementServiceMock.geTotalClicks(DATA_SOURCE, START_DATE, endDateOptional)).willReturn(expectedTotalCLicks);

        //when
        long totalClicks = advertisementController.geTotalClicks(DATA_SOURCE, START_DATE, endDateOptional);

        //then
        assertThat(totalClicks).isEqualTo(expectedTotalCLicks);
        then(advertisementServiceMock).should().geTotalClicks(DATA_SOURCE, START_DATE, endDateOptional);
    }

    @Test
    void getClickThroughRate() {
        String campaign = "Adventmarkt Touristik";
        long expectedClickThroughRate = 100_000L;
        given(advertisementServiceMock.getClickThroughRate(DATA_SOURCE, campaign)).willReturn(expectedClickThroughRate);

        //when
        long clickThroughRate = advertisementController.getClickThroughRate(DATA_SOURCE, campaign);

        //then
        assertThat(clickThroughRate).isEqualTo(expectedClickThroughRate);
        then(advertisementServiceMock).should().getClickThroughRate(DATA_SOURCE, campaign);
    }

    @Test
    void getImpressions() {
        long expectedImpressions = 100_000L;
        given(advertisementServiceMock.getImpressions(START_DATE)).willReturn(expectedImpressions);

        //when
        long impressions = advertisementController.getImpressions(START_DATE);

        //then
        assertThat(impressions).isEqualTo(expectedImpressions);
        then(advertisementServiceMock).should().getImpressions(START_DATE);
    }
}
