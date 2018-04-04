package jvm.compile;

/**
 * @Author pierre
 * 18-3-15
 */
public class GenericDemo {

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println((c == d) == true);
        System.out.println((e == f) == false);
        System.out.println((c == (a + b)) == true);
        System.out.println((c.equals(d)) == true);
        System.out.println((g == (a + b)) == true);
        System.out.println((g.equals(a + b)) == false);
    }
}
