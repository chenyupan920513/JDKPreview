package com.cyp.design.patterns.observer;

/**
 * @Author pierre.chen
 * <url>http://www.runoob.com/design-pattern/observer-pattern.html</url>
 * @Date 18-5-19
 */
public class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();

        subject.addObserver(new HexaObserver());
        subject.addObserver(new OctalObserver());
        subject.addObserver(new BinaryObserver());

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);

    }
}
