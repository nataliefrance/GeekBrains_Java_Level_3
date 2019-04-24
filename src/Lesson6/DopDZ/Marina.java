package Lesson6.DopDZ;

public class Marina {

    private String name;
    private String cargo;
    private int cargoQuantity;

    Marina(String name, String cargo, int cargoQuantity) {
        this.name = name;
        this.cargo = cargo;
        this.cargoQuantity = cargoQuantity;
    }

    public String getName() {
        return name;
    }

    String getCargo() {
        return cargo;
    }

    int getCargoQuantity() {
        return cargoQuantity;
    }

    void load(Ship ship) throws InterruptedException {
        while(ship.getCargoQuantity() < ship.getCapacity() && cargoQuantity > 0) {
            ship.setCargoQuantity(ship.getCargoQuantity() + 100);
            cargoQuantity = cargoQuantity - 100;
            Thread.sleep(100);
            if (cargoQuantity == 0){
                Main.finishLoad.decrementAndGet();
            }
        }
        System.out.println(ship.getName() + " загрузил " + ship.getCargoQuantity() + " " + cargo);
    }

    void unload(Ship ship) throws InterruptedException {
        int i = ship.getCargoQuantity();
        while(ship.getCargoQuantity() > 0) {
            ship.setCargoQuantity(ship.getCargoQuantity() - 100);
            this.cargoQuantity = this.cargoQuantity + 100;
            Thread.sleep(100);
        }
        System.out.println(ship.getName() + " разгрузил " + i + " " + cargo);

    }
}
