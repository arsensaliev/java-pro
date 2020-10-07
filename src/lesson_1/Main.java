package lesson_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer[] arr1 = {321, 435, 6546, 45};
        String[] arr2 = {"11", "22", "33", "44"};

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

        System.out.println(Arrays.toString(changePosition(arr1, 0, 1)));
        System.out.println(Arrays.toString(changePosition(arr2, 1, 3)));

        System.out.println(replaceArr(arr1).getClass().getName());


        Box<Apple> appleBox = new Box<>();
        Box<Apple> appleBox1 = new Box<>();
        Box<Orange> orangeBox = new Box<>();

        for (int i = 0; i < 6; i++) {
            appleBox.addToBox(new Apple());
        }

        for (int i = 0; i < 4; i++) {
            orangeBox.addToBox(new Orange());
        }

        System.out.println(appleBox.getWeight());
        System.out.println(orangeBox.getWeight());

        System.out.println(appleBox.compare(orangeBox));

        appleBox1.moveOnOtherBox(appleBox);

        System.out.println(appleBox.getWeight());
        System.out.println(appleBox1.getWeight());
    }

    static <T> T[] changePosition(T[] arr, int i, int j) {
        T t1 = arr[i];
        arr[i] = arr[j];
        arr[j] = t1;
        return arr;
    }


    static <T> List<T> replaceArr(T[] arr) {
        return Arrays.asList(arr);
    }
}
