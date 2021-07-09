package com.tryton.adv.server.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping(value = "/advertisement")
public class AdvertisementController {

    @GetMapping("/total-clicks")
    public long geTotalClicks(@RequestParam String dataSource,
                              @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                              @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Optional<LocalDate> endDateOptional) {

//        SELECT coalesce(sum(coalesce(met_clicks, 0)) , 0)
//        FROM adv_db.metrics
//        JOIN adv_db.campaign ON met_cpg_id = cpg_id
//        JOIN adv_db.datasource ON ds_id = cpg_ds_id
//        WHERE ds_name = 'Google Ads'
//        AND met_daily >= '2019-03-13'
//        AND met_daily <= '2019-03-14'
//        ;
//
        return 0;
    }

    @GetMapping("/click-through-rate")
    public long getClickThroughRate(@RequestParam String dataSource,
                                    @RequestParam String campaign) {
//        SELECT coalesce(sum(coalesce(met_clicks, 0)) , 0)
//        FROM adv_db.metrics
//        JOIN adv_db.campaign ON met_cpg_id = cpg_id
//        JOIN adv_db.datasource ON ds_id = cpg_ds_id
//        WHERE cpg_name = 'Touristik City Guide_Android'
//        AND ds_name = 'Google Ads';

        return 0;
    }

    @GetMapping("/impressions")
    public long getImpressions(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {

//        SELECT coalesce(sum(met_impressions)), 0)
//        FROM adv_db.metrics
//        WHERE met_daily = '2019-03-13'
        return 0;
    }
}
