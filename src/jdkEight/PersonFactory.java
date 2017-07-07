package jdkEight;

/**
 * Created by Administrator on 2017/4/17.
 */
public interface PersonFactory<P extends  Person> {
    P create(String firstName, String lastName);
}
