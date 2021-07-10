package com.tryton.adv.server.controller;

import com.tryton.adv.server.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Optional;

import static java.util.Objects.requireNonNull;

@RestController
@RequestMapping(value = "/advertisement")
public class AdvertisementController {

    private final AdvertisementService advertisementService;

    @Autowired
    public AdvertisementController(AdvertisementService advertisementService) {
        this.advertisementService = requireNonNull(advertisementService);
    }

    @GetMapping("/total-clicks")
    public long geTotalClicks(@RequestParam String dataSource,
                              @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                              @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Optional<LocalDate> endDateOptional) {

        return 0;
    }

    @GetMapping("/click-through-rate")
    public long getClickThroughRate(@RequestParam String dataSource,
                                    @RequestParam String campaign) {


        return 0;
    }

    @GetMapping("/impressions")
    public long getImpressions(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {

        return 0;
    }
}
