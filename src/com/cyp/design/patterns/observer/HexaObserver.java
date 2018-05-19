package com.cyp.design.patterns.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @Author pierre.chen
 * <url>http://www.runoob.com/design-pattern/observer-pattern.html</url>
 * @Date 18-5-19
 */
public class HexaObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Hex String: "
                + Integer.toHexString(((Subject) o).getState()).toUpperCase());
    }
}
