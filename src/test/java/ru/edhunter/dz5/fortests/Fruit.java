package ru.edhunter.dz5.fortests;

public class Fruit extends Eatable implements Comparable<Fruit>{
    public Fruit(int size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fruit fruit = (Fruit) o;

        return size == fruit.size;
    }

    @Override
    public int hashCode() {
        return size;
    }

    @Override
    public int compareTo(Fruit o) {
        return Integer.compare(this.size, o.getSize());
    }
}
