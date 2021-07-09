package com.tryton.adv.server.service;

import com.tryton.adv.server.dataprovider.impl.AdvertisementMapper;
import com.tryton.adv.server.util.DateProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import static java.util.Objects.requireNonNull;

@Service
public class DbBasedAdvertisementService implements AdvertisementService {
    private final DateProvider dateProvider;
    private final AdvertisementMapper advertisementMapper;

    @Autowired
    public DbBasedAdvertisementService(DateProvider dateProvider, AdvertisementMapper advertisementMapper) {
        this.dateProvider = requireNonNull(dateProvider);
        this.advertisementMapper = requireNonNull(advertisementMapper);
    }

    @Override
    public long geTotalClicks(String dataSource, LocalDate localStartDate, Optional<LocalDate> localEndDateOptional) {
        Date startDate = dateProvider.toDate(localStartDate);
        Date endDate = localEndDateOptional.isPresent() ? dateProvider.toDate(localEndDateOptional.get()) : null;
        return advertisementMapper.geTotalClicks(dataSource, startDate, endDate);
    }

    @Override
    public long getClickThroughRate(String dataSource, String campaign) {
        return advertisementMapper.getClickThroughRate(dataSource, campaign);
    }

    @Override
    public long getImpressions(LocalDate date) {
        Date daily = dateProvider.toDate(date);
        return advertisementMapper.getImpressions(daily);
    }
}
