package Lesson7;

public class Spiral {

    static final int SIZE = 4;

    public static void main(String[] args) {
        Spiral spiral = new Spiral();
        int[][] array = new int[SIZE][SIZE];

        spiral.fill(array);
        spiral.print(array);
        System.out.println();
        System.out.println(1 % 2);

    }

    private void fill(int[][] array){
            int row = 0; //строка
            int col = 0; //столбец
            int x = 1;
            int y = 0;
            int dirChanges = 0;
            int visits = SIZE;

            for (int i = 0; i < SIZE * SIZE; i++) {
                array[row][col] = i + 1;
                visits--;
                if (visits == 0) {
                    visits = SIZE * (dirChanges % 2) +
                            SIZE * ((dirChanges + 1) % 2) -
                            (dirChanges / 2 - 1) - 2;
                    int a = x;
                    x = -y;
                    y = a;
                    dirChanges++;
                }
                col = col + x;
                row = row + y;
            }
    }

    private void print(int[][] array) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++)
                System.out.print(array[i][j] + " ");
            System.out.println();
        }
    }
}
