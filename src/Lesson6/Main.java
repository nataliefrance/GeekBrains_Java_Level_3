package Lesson6;

import java.util.ArrayList;

class Main {
    
    //2. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив. 
    // Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов, 
    // идущих после последней четверки. 
    // Входной массив должен содержать хотя бы одну четверку, 
    // иначе в методе необходимо выбросить RuntimeException. 
    // Написать набор тестов для этого метода (по 3-4 варианта входных данных). Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].

    Integer[] afterFour (int[] inputArray){
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = inputArray.length - 1; i >= 0 ; i--) {
            if (inputArray[i] == 4){
                break;
            }
            list.add(0, inputArray[i]);
        }
        return list.toArray(new Integer[0]);
    }

    //3. Написать метод, который проверяет состав массива из чисел 1 и 4.
    // Если в нем нет хоть одной четверки или единицы, то метод вернет false;
    // Написать набор тестов для этого метода (по 3-4 варианта входных данных).

    boolean hasOneOrFour(int[] inputArray){
        for (int i : inputArray) {
            if (i == 1 || i == 4) {
                return true;
            }
        }
        return false;
    }
}
