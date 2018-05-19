package com.cyp.design.patterns.command;

/**
 * @Author pierre.chen
 * @Date 18-5-19
 */
public class SellStock implements Order {
    private Stock abcStock;

    public SellStock(Stock abcStock) {
        this.abcStock = abcStock;
    }

    public void execute() {
        abcStock.sell();
    }
}
