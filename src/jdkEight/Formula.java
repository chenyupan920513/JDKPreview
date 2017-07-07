package jdkEight;

/**
 * Created by Administrator on 2017/4/17.
 */
public interface Formula {

    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
