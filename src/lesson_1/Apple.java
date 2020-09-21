package lesson_1;

public class Apple implements Fruit {
    private static final float WEIGHT = 1.0f;

    @Override
    public float getWeight() {
        return WEIGHT;
    }
}
