package Lesson6.DopDZ;

import java.util.concurrent.Semaphore;

public class Strait {
    private Semaphore smp = new Semaphore(Main.STRAIT_PERMIT);

    public void go(Ship ship) {
        try {
            System.out.println(ship.getName() + " подплыл к проливу.");
            smp.acquire();
            System.out.println(ship.getName() + " зашёл в пролив.");
            Thread.sleep( 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(ship.getName() + " пересёк пролив.");
            smp.release();
        }
    }
}
