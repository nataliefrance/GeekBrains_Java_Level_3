package Lesson6.DopDZ;

public class Ship implements Runnable {

    private String name;
    private int capacity;
    private int cargoQuantity;
    private String cargo;
    private Marina[] unloadMarinas;
    private Marina[] loadMarinas;
    private Strait strait; //Если привов будет несколько, можно создать отедльный класс типа Race, который был в гонках, и добавлять его.

    Ship(String name, int capacity, Marina[] unloadMarinas, Marina[] loadMarinas, Strait strait) {
        this.cargoQuantity = 0;
        this.name = name;
        this.capacity = capacity;
        this.unloadMarinas = unloadMarinas;
        this.loadMarinas = loadMarinas;
        this.strait = strait;
    }

    public String getName() {
        return name;
    }

    int getCapacity() {
        return capacity;
    }

    void setCargoQuantity(int cargoQuantity) {
        this.cargoQuantity = cargoQuantity;
    }

    int getCargoQuantity() {
        return cargoQuantity;
    }

    @Override
    public void run() {
        try {
            while (Main.finishLoad.get() > 0) {
                strait.go(this);
                load(loadMarinas);
                strait.go(this);
                if (cargoQuantity > 0) {
                    unload(unloadMarinas);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void load(Marina[] loadMarinas) throws InterruptedException {
        for (Marina loadMarina : loadMarinas) {
            synchronized (loadMarina) {
                if (loadMarina.getCargoQuantity() > 0) {
                    this.cargo = loadMarina.getCargo();
                    loadMarina.load(this);
                    break;
                }
            }
        }
    }

    private void unload(Marina[] unloadMarinas) throws InterruptedException {
        for (Marina unloadMarina : unloadMarinas) {
            if (unloadMarina.getCargo().equals(this.cargo)) {
                unloadMarina.unload(this);
                break;
            }
        }
    }
}
