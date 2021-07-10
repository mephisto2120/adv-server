package com.tryton.adv.server.util;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

class DateProviderTest {

    private static final int YEAR = 2019;
    private static final int MONTH = 10;
    private static final int DAY = 11;
    private static final int FRIDAY = 5;

    private final DateProvider dateProvider = new DateProvider();

    @Test
    void toDate() {
        //given
        LocalDate localDate = LocalDate.of(YEAR, MONTH, DAY);

        //when
        Date date = dateProvider.toDate(localDate);

        //then
        assertThat(date.getYear()).isEqualTo(YEAR - 1900);
        assertThat(date.getMonth()).isEqualTo(MONTH - 1);
        assertThat(date.getDay()).isEqualTo(FRIDAY);
    }
}
