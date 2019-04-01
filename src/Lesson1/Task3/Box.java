package Lesson1.Task3;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    //Для хранения фруктов внутри коробки можно использовать ArrayList;
    private ArrayList<T> list;

    //Сделать метод getWeight(), который высчитывает вес коробки, зная количество фруктов и вес одного фрукта
    float getWeight() {
        float result = 0;
        for (int i = 0; i < list.size(); i++) {
            result += list.get(i).getWeight();
        }
        return result;
    }

    //Внутри класса Коробка сделать метод compare, который позволяет сравнить текущую коробку с той,
    // которую подадут в compare в качестве параметра,
    // true – если она равны по весу,
    // false – в противном случае
    // коробки с яблоками мы можем сравнивать с коробками с апельсинами);
    boolean compare(Box<? super T> box) {
        return this.getWeight() == box.getWeight();
    }

    //Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую
    //помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами).
    //Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
    void pourTo(Box<T> anotherBox){
        anotherBox.list.addAll(list);
        list.clear();
    }


    //Метод добавления фрукта в коробку.
    void addFruits(int amount, T fruit){
        this.list = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            list.add(fruit);
        }
    }
}
