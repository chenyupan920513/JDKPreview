package jdkEight.test;

import jdkEight.Converter;

/**
 * Created by Administrator on 2017/4/17.
 */
public class ConvertTest {
    public static void main(String[] args) {
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted);    // 123


        Converter<String, Integer> converter2 = Integer::valueOf;
        Integer converted2 = converter2.convert("456");
        System.out.println(converted2);   // 123

        String something = new String();


        converter = something::compareTo;
        Integer converted3 = converter.convert("Java");
        System.out.println(converted);    // "J"


    }
}
