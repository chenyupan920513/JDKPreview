package com.cyp.design.patterns.command;

/**
 * @Author pierre.chen
 * @Date 18-5-19
 */
public class BuyStock implements Order{
    private Stock abcStock;

    public BuyStock(Stock abcStock){
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.buy();
    }
}
