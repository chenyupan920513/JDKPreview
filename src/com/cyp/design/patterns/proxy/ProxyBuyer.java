package com.cyp.design.patterns.proxy;

/**
 * Created by Administrator on 2017/4/24.
 */
public class ProxyBuyer implements IShop {

    private IShop mShop;

    public ProxyBuyer(IShop mShop) {
        this.mShop = mShop;
    }

    @Override
    public void buy() {
        mShop.buy();
    }
}
