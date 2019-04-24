package Lesson6.DopDZ;

import java.util.concurrent.atomic.AtomicInteger;

/*
1 Есть транспортные корабли, которые подплывают к проливу и далее
  плывут к причалам для погрузки разного рода товара.

2 Они проходят через узкий пролив где одновременно могут находиться
  только 2 корабля.

3 Вид кораблей и их вместительность могут быть разными в зависимости от типа товаров,
  которые нужно загрузить на корабль. (Представим что корабли везут Одежду, Еду, Топливо)

4 Есть 3 вида причалов для погрузки кораблей в соотвествие с товарами,
  за одну секунду причал загружает на корабль 100 ед. товара, вместимость кораблей 500.

5 После загрузки нужно пройти обратно через пролив и перевести товар.

6 Нужно перевести 2700 ед. одежды, 5900 еды, 8500 топлива.

Перевести груз.
Правильно разбить задачу на параллельность.
Синхронизировать потоки, сохранить целостность данных.
 */
public class Main {

    static final int STRAIT_PERMIT = 2;
    private static final int SHIPS_CAPACITY = 500; //все корабли пусть будут одинаковые
    private static final int SHIPS_COUNT = 5;
    static AtomicInteger finishLoad;

    public static void main(String[] args) {
        Marina[] unloadMarinas = {
                new Marina("Marina4", "fuel", 0),
                new Marina("Marina5", "food", 0),
                new Marina("Marina6", "clothes", 0),
        };

        Marina[] loadMarinas = {
                new Marina("Marina1", "fuel", 8500),
                new Marina("Marina2", "food", 5900),
                new Marina("Marina3", "clothes", 2700),
        };

        finishLoad = new AtomicInteger(loadMarinas.length);

        Strait strait = new Strait();

        Ship[] ships = new Ship[SHIPS_COUNT];
        for (int i = 0; i < SHIPS_COUNT; i++) {
            ships[i] = new Ship("ship" + i, SHIPS_CAPACITY, unloadMarinas, loadMarinas, strait);
        }

        for (Ship ship : ships){
            new Thread(ship).start();
        }


    }
}
