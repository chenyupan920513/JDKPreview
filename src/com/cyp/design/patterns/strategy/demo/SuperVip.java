package com.cyp.design.patterns.strategy.demo;

import com.cyp.design.patterns.strategy.demo.retention.PriceRegion;

/**
 * Created by Administrator on 2017/4/14.
 */
@PriceRegion(max = 30000,min = 20000)
public  class SuperVip implements CalPrice {

    @Override
    public Double calPrice(Double orgnicPrice) {
        return orgnicPrice * 0.8;
    }


}
