package beans;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private int age;

    public Person() {}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    // Main method for testing
    public static void main(String[] args) {
        Person p = new Person();
        p.setName("Anushka");
        p.setAge(22);
        System.out.println("Name: " + p.getName() + ", Age: " + p.getAge());
    }
}
