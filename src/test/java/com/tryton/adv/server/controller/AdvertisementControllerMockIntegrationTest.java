package com.tryton.adv.server.controller;

import com.tryton.adv.server.service.AdvertisementService;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.io.Reader;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
@Tag("integration")
public class AdvertisementControllerMockIntegrationTest {

    private static final String TOTAL_CLICKS = "/advertisement/total-clicks";
    private static final String CLICK_THROUGH_RATE = "/advertisement/click-through-rate";
    private static final String IMPRESSIONS = "/advertisement/impressions";
    private static final String DATA_SOURCE = "Facebook Ads";
    private static final String START_DATE = "2019-03-03";

    @MockBean
    private AdvertisementService advertisementServiceMock;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnBadRequestWhenDateInInvalidFormat() throws Exception {
        mockMvc.perform(get(TOTAL_CLICKS)
                .param("dataSource", DATA_SOURCE)
                .param("startDate", "02/13/2020"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("IllegalArgumentException: Parse attempt failed for value [02/13/2020]")));
    }

    @Test
    void shouldReturnBadRequestWhenNoParameterGiven() throws Exception {
        mockMvc.perform(get(TOTAL_CLICKS))
                .andExpect(status().isBadRequest());
    }
}
