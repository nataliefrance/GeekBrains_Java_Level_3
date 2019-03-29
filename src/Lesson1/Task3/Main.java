package Lesson1.Task3;

public class Main {
    public static void main(String[] args) {
        Box <Apple> appleBox1 = new Box<>();
        Box <Apple> appleBox2 = new Box<>();
        Box <Orange> orangeBox2 = new Box<>();

        appleBox1.addFruits(10, new Apple());
        appleBox2.addFruits(5, new Apple());
        orangeBox2.addFruits(20, new Orange());

        System.out.println("Вес appleBox1: " + appleBox1.getWeight());
        System.out.println("Вес appleBox2: " + appleBox2.getWeight());
        System.out.println("Вес orangeBox2: " + orangeBox2.getWeight());

        System.out.println("Коробки appleBox1 и orangeBox2 равны? " + appleBox1.compare(orangeBox2));

        System.out.println("Пересыпаем appleBox1 в appleBox2");
        appleBox1.pourTo(appleBox2);
        System.out.println("Вес appleBox1: " + appleBox1.getWeight() + ". Вес appleBox2: " + appleBox2.getWeight());

    }
}
