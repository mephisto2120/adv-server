package com.tryton.adv.server.service;

import com.tryton.adv.server.dataprovider.impl.AdvertisementMapper;
import com.tryton.adv.server.util.DateProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
public class DbBasedAdvertisementServiceTest {

    private static final String DATA_SOURCE = "Google Ads";
    private static final LocalDate START_DATE = LocalDate.of(2019, 3, 3);
    private static final LocalDate END_DATE = LocalDate.of(2019, 3, 13);
    private static final String CAMPAIGN = "Adventmarkt Touristik";

    @Mock
    private DateProvider dateProviderMock;
    @Mock
    private AdvertisementMapper advertisementMapperMock;

    @InjectMocks
    private DbBasedAdvertisementService dbBasedAdvertisementService;

    @Test
    void getClickThroughRate() {
        //given
        long expectedClickThroughRate = 10_000L;
        given(advertisementMapperMock.getClickThroughRate(DATA_SOURCE, CAMPAIGN)).willReturn(expectedClickThroughRate);

        //when
        long clickThroughRate = dbBasedAdvertisementService.getClickThroughRate(DATA_SOURCE, CAMPAIGN);

        //then
        assertThat(clickThroughRate).isEqualTo(expectedClickThroughRate);
        then(advertisementMapperMock).should().getClickThroughRate(DATA_SOURCE, CAMPAIGN);
    }

    @Test
    void getImpressions() {
        //given
        long expectedImpressions  = 20_000L;
        Date startDate = new Date(1L);
        given(dateProviderMock.toDate(START_DATE)).willReturn(startDate);
        given(advertisementMapperMock.getImpressions(startDate)).willReturn(expectedImpressions);

        //when
        long impressions = dbBasedAdvertisementService.getImpressions(START_DATE);

        //then
        assertThat(impressions).isEqualTo(expectedImpressions);
        then(dateProviderMock).should().toDate(START_DATE);
        then(advertisementMapperMock).should().getImpressions(startDate);
    }

    @Test
    void geTotalClicks() {
        //given
        long expectedTotalClicks = 20_000L;
        Date startDate = new Date(1L);
        Date endDate = new Date(2L);
        given(dateProviderMock.toDate(START_DATE)).willReturn(startDate);
        given(dateProviderMock.toDate(END_DATE)).willReturn(endDate);
        given(advertisementMapperMock.geTotalClicks(DATA_SOURCE, startDate, endDate)).willReturn(expectedTotalClicks);
        Optional<LocalDate> optionalLocalDate = Optional.of(END_DATE);

        //when
        long totalClicks = dbBasedAdvertisementService.geTotalClicks(DATA_SOURCE, START_DATE, optionalLocalDate);

        //then
        assertThat(totalClicks).isEqualTo(expectedTotalClicks);
        then(dateProviderMock).should().toDate(START_DATE);
        then(dateProviderMock).should().toDate(END_DATE);
        then(advertisementMapperMock).should().geTotalClicks(DATA_SOURCE, startDate, endDate);
    }

    @Test
    void geTotalClicksWhenEndDateNotGiven() {
        //given
        long expectedTotalClicks = 20_000L;
        Date startDate = new Date(1L);
        given(dateProviderMock.toDate(START_DATE)).willReturn(startDate);
        given(advertisementMapperMock.geTotalClicks(DATA_SOURCE, startDate, null)).willReturn(expectedTotalClicks);
        Optional<LocalDate> emptyDate = Optional.empty();

        //when
        long totalClicks = dbBasedAdvertisementService.geTotalClicks(DATA_SOURCE, START_DATE, emptyDate);

        //then
        assertThat(totalClicks).isEqualTo(expectedTotalClicks);
        then(dateProviderMock).should().toDate(START_DATE);
        then(advertisementMapperMock).should().geTotalClicks(DATA_SOURCE, startDate, null);
    }
}
