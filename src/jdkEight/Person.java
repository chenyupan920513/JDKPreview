package jdkEight;

/**
 * Created by Administrator on 2017/4/17.
 */
public class Person {
    String firstName;
    String lastName;

    Person() {}

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
