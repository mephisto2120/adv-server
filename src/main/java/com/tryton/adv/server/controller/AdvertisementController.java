package com.tryton.adv.server.controller;

import com.tryton.adv.server.service.AdvertisementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "Calculates metrics")
public class AdvertisementController {

    private final AdvertisementService advertisementService;

    @Autowired
    public AdvertisementController(AdvertisementService advertisementService) {
        this.advertisementService = requireNonNull(advertisementService);
    }

    @GetMapping("/total-clicks")
    @ApiOperation(value = "Calculates total clicks for a given Datasource for a given Date range")
    public long geTotalClicks(@RequestParam String dataSource,
                              @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                              @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Optional<LocalDate> endDateOptional) {
        return advertisementService.geTotalClicks(dataSource, startDate, endDateOptional);
    }

    @GetMapping("/click-through-rate")
    @ApiOperation(value = "Calculates Click-Through Rate (CTR) per Datasource and Campaign")
    public long getClickThroughRate(@RequestParam String dataSource,
                                    @RequestParam String campaign) {
        return advertisementService.getClickThroughRate(dataSource, campaign);
    }

    @GetMapping("/impressions")
    @ApiOperation(value = "Calculates impressions over time (daily)")
    public long getImpressions(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return advertisementService.getImpressions(date);
    }
}
