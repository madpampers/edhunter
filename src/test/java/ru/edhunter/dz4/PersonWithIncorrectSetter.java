package ru.edhunter.dz4;

public class PersonWithIncorrectSetter {
    private String name;
    private int age;

    public PersonWithIncorrectSetter(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge () {
        return this.age;
    }

    public void setNameAndAge(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
