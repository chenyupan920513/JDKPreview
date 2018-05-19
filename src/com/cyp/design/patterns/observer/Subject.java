package com.cyp.design.patterns.observer;

import java.util.Observable;

/**
 * @Author pierre.chen
 * <url>http://www.runoob.com/design-pattern/observer-pattern.html</url>
 * @Date 18-5-19
 */
public class Subject extends Observable {

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        this.setChanged();
        this.notifyObservers();
    }

}
