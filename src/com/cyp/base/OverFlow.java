package com.cyp.base;

import java.math.BigDecimal;

/**
 * @Author pierre.chen
 * @Date 18-5-19
 */
public class OverFlow {

    private static byte bt = -0b10000000;//-128


    public static void main(String[] args) {
        System.out.println(bt);
        BigDecimal bigDecimal = BigDecimal.ZERO;
    }


}
