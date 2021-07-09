package com.tryton.adv.server.dataprovider.impl;

import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface AdvertisementMapper {
    long getImpressions(@Param("daily") Date daily);

    long getClickThroughRate(@Param("dataSource") String dataSource, @Param("campaign") String campaign);

    long geTotalClicks(@Param("dataSource") String dataSource, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
