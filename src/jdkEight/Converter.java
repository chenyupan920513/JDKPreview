package jdkEight;

/**
 * Created by Administrator on 2017/4/17.
 */
public interface Converter<F, T> {
    T convert(F from);
}
