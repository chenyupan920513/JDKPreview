package jdkEight.test;



import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2017/4/17.
 */
public class LambdaTest {


    public static void main(String[] args) {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        Collections.sort(names, (a,b)->b.compareTo(a+1));

    }
}
