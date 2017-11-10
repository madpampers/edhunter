package ru.edhunter.dz5.fortests;

public class Pineapple extends Fruit {

    public Pineapple(int size) {
        super(size);
    }

    public Pineapple (int size, int tasteRating) {
        super(size);
        this.tasteRating = tasteRating;
    }

    public int getTasteRating() {
        return tasteRating;
    }
}
