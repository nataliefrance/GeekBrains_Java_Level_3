package Lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        String[] arr1 = {"a", "b", "c", "d"};
        Integer[] arr2 = {1, 2, 3, 4, 5};
        main.swap(arr1, 2, 3);
        main.swap(arr2, 3, 4);

        main.toArrayList(arr1);
        main.toArrayList(arr2);
    }

    //1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
    private void swap(Object[] array, int n1, int n2){
        System.out.println("Массив на входе: " + Arrays.toString(array));
        Object o = array[n1];
        array[n1] = array[n2];
        array[n2] = o;
        System.out.println("Массив на выходе: " + Arrays.toString(array));
    }

    //2. Написать метод, который преобразует массив в ArrayList;
    private <T> ArrayList<T> toArrayList(T[] array){
        return new ArrayList<>(Arrays.asList(array));
    }
}
