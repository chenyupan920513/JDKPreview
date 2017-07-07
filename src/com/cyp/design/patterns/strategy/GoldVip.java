package com.cyp.design.patterns.strategy;

import com.cyp.design.patterns.strategy.retention.PriceRegion;

/**
 * Created by Administrator on 2017/4/14.
 */
@PriceRegion(min = 30000)
public  class GoldVip implements CalPrice {

    @Override
    public Double calPrice(Double orgnicPrice) {
        return orgnicPrice * 0.7;
    }


}
