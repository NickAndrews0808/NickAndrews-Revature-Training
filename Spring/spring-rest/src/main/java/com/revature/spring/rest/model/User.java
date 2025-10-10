package com.revature.spring.rest.model;

public class User {
    private String name;
    private int age;

    // Default no-arg constructor
    public User() {}

    // Convenience constructor used by controllers
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Keep the original signature if other code uses it, adapt fields accordingly
    public User(int age, String name, String email) {
        this.age = age;
        this.name = name;
        // email parameter ignored for now; add field if needed later
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
