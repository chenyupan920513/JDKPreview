package jdkEight.test;

import jdkEight.Formula;

/**
 * Created by Administrator on 2017/4/17.
 */
public class TestFormula {
   public static Formula formula = new Formula() {
        @Override
        public double calculate(int a) {
            return sqrt(a );
        }
    };

    public static void main(String[] args) {
        System.out.println(formula.calculate(100));
        System.out.println(formula.calculate(16));
    }
}
