package Lesson4;

//Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз (порядок – ABСABСABС).

public class Main {
    private static volatile char letter = 'A';
    private static Object monitor = new Object();

    public static void main(String[] args) {
        Thread tA = new Thread(new PrintLetter('A', 'B'));
        Thread tB = new Thread(new PrintLetter('B', 'C'));
        Thread tC = new Thread(new PrintLetter('C', 'A'));

        tA.start();
        tB.start();
        tC.start();
    }

    static class PrintLetter implements Runnable {

        private char letterToPrint;
        private char nextLetter;

        PrintLetter(char letterToPrint, char nextLetter) {
            this.letterToPrint = letterToPrint;
            this.nextLetter = nextLetter;
        }

        @Override
        public void run() {
            synchronized (monitor) {
                try {
                    for (int i = 0; i < 5; i++) {
                        while (letter != letterToPrint) {
                            monitor.wait();
                        }
                        System.out.print(letterToPrint);
                        letter = nextLetter;
                        monitor.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }


}
