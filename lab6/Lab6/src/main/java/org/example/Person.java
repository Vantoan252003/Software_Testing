package org.example;

/**
 * Class for demonstrating exception testing with multiple techniques
 * Used in BÀI 2 - Test exception with 3 techniques
 */
public class Person {
    private String name;
    private int age;

    /**
     * Constructor for Person
     * @param name the person's name
     * @param age the person's age
     * @throws IllegalArgumentException if age is negative
     */
    public Person(String name, int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
