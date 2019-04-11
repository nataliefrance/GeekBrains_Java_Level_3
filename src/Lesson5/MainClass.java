package Lesson5;

import java.util.concurrent.*;

public class MainClass {
    private static final int CARS_COUNT = 4;
    //Создаем CountDownLatch на CARS_COUNT машин
    static final CountDownLatch START = new CountDownLatch(CARS_COUNT + 1);
    static final Semaphore sem = new Semaphore(CARS_COUNT / 2);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        while (START.getCount() > 1) //Проверяем, собрались ли все автомобили
            Thread.sleep(100);
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        START.countDown(); //Команда дана, уменьшаем счетчик на 1
        //счетчик становится равным нулю, и все ожидающие потоки одновременно разблокируются

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}






