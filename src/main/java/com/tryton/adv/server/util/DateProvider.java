package com.tryton.adv.server.util;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Component
public class DateProvider {

    private static final ZoneId ZONE_ID = ZoneId.systemDefault();

    public Date toDate(LocalDate dateToConvert) {
        return java.util.Date.from(dateToConvert.atStartOfDay()
                .atZone(ZONE_ID)
                .toInstant());
    }
}
