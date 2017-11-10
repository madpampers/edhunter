package ru.edhunter.dz5.fortests;

public class TestClass<T> {
    private T t;

    public TestClass(T t) {
        this.t = t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public <S> void makeS (S s) {
        System.out.println(t);
    }

}
