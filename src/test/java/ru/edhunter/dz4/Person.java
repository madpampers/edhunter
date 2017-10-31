package ru.edhunter.dz4;

public class Person {
    private String name;
    private int age;
    private Pet pet = null;
    private boolean male;

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Pet getPet() {

        return pet;
    }

    public Person(String name, int age, boolean sex) {
        this.name = name;
        this.age = age;
        this.male = sex;
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

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }
}
