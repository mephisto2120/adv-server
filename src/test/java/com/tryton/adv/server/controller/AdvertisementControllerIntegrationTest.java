package com.tryton.adv.server.controller;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
@Tag("integration")
class AdvertisementControllerIntegrationTest {

    private static final String TOTAL_CLICKS = "/advertisement/total-clicks";
    private static final String CLICK_THROUGH_RATE = "/advertisement/click-through-rate";
    private static final String IMPRESSIONS = "/advertisement/impressions";
    private static final String DATA_SOURCE = "Facebook Ads";
    private static final String START_DATE = "2019-03-03";

    @Autowired
    private MockMvc mockMvc;

    @Test
    void geTotalClicks() throws Exception {
        mockMvc.perform(get(TOTAL_CLICKS)
                .param("dataSource", DATA_SOURCE)
                .param("startDate", "2020-02-13")
                .param("endDate", "2020-02-14"))
                .andExpect(status().isOk())
                .andExpect(content().string("11"));
    }

    @Test
    void geTotalClicksWhenEndDateNotGiven() throws Exception {
        mockMvc.perform(get(TOTAL_CLICKS)
                .param("dataSource", "Facebook Ads")
                .param("startDate", "2020-02-13"))
                .andExpect(status().isOk())
                .andExpect(content().string("11"));
    }

    @Test
    void getClickThroughRate() throws Exception {
        //given
        String campaign = "Adventmarkt Touristik";

        //when-then
        mockMvc.perform(get(CLICK_THROUGH_RATE)
                .param("dataSource", DATA_SOURCE)
                .param("campaign", campaign))
                .andExpect(status().isOk())
                .andExpect(content().string("1242"));
    }

    @Test
    void getImpressions() throws Exception {
        //when-then
        mockMvc.perform(get(IMPRESSIONS)
                .param("date", START_DATE))
                .andExpect(status().isOk())
                .andExpect(content().string("63639"));
    }
}
