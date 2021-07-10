package com.tryton.adv.server.service;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Optional;

public interface AdvertisementService {
    long geTotalClicks(String dataSource,
                       LocalDate startDate,
                       Optional<LocalDate> endDateOptional);

    long getClickThroughRate(String dataSource, String campaign);

    long getImpressions(LocalDate date);
}
