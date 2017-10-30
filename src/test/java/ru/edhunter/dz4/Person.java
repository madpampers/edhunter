package ru.edhunter.dz4;

public class Person {
    private String name;
    private int age;
    private Pet pet = null;

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Pet getPet() {

        return pet;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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
