package jdkEight.test;

import jdkEight.Person;
import jdkEight.PersonFactory;

/**
 * Created by Administrator on 2017/4/17.
 */
public class PersonTest {
    public static void main(String[] args) {
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Parker");
        System.out.println(person);
    }
}
