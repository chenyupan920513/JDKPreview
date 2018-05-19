package com.cyp.design.patterns.strategy;

/**
 * @Author pierre.chen
 * @Date 18-5-19
 */
public class OperationMultiply implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
