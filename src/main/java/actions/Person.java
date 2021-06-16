package actions;

import java.util.List;

public class Person {
    private String name;
    private int age;
    private List<String> address;

    public Person(String name, int age, List<String> address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}
