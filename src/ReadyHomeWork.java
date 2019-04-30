public class ReadyHomeWork {

    /*
     * Написать метод вычисляющий выражение a * (b + (c / d)) и
     * возвращающий результат, где a,b,c,d – входные параметры этого метода.
     */
    private static int calculate(int a, int b, int c, int d) {

        // Поскольку заданием не регламентировано какого типа должно быть
        // возвращаемое значение - создадим несколько методов
        return a * (b + (c / d));
    }

    private static float calculate(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    /*
     * Написать метод, принимающий на вход два числа, и проверяющий
     * что их сумма лежит в пределах 10 до 20, если да – вернуть true,
     * в противном случае – false.
     */
    private static boolean checkTwoNumbers(int first, int second) {
        int sum = first + second;
        return sum <= 20 && sum >= 10;
    }

    /*
     * Написать метод, которому в качестве параметра передаётся целое число,
     * метод должен напечатать в консоль положительное ли число передали
     * или отрицательное; Замечание: ноль считаем положительным числом.
     */
    private static void printIsPositive(int variable) {
        System.out.println((variable >= 0) ? "positive" : "negative");
    }

    /*
     * Написать метод, которому в качестве параметра передаётся
     * целое число, метод должен вернуть true если число отрицательное
     */
    private static boolean isNegative(int variable) {
        return (variable < 0);
    }

    /*
     * Написать метод, которому в качестве параметра передаётся строка,
     * обозначающая имя, метод должен вывести в консоль сообщение "Привет, указанное_имя!"
     */
    private static void printWelcome(String name) {
        System.out.println("Привет, " + name + "!");
    }

    /*
     * Написать метод, который определяет является ли год високосным.
     * Каждый 4-й год является високосным, кроме каждого 100-го,
     * при этом каждый 400-й – високосный.
     */
    private static boolean isLeapYear(int year) {
        return (year % 100 != 0) && (year % 4 == 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        /*
         * Создание переменных всех пройденных типов данных
         * Я даже не стал копипастить это из методички
         * (в конце которой, как Вы могли заметить,
         * выполнение домашки расписано весьма подробно)
         */
        byte b = 127;
        short s = 32767;
        int i = 1234;
        long l = 4321L;
        char c = 65;
        float f = 1234.5678f;
        double d = 5678.1234;
        boolean boo = true;
        String str = "Fancy String";

        // Просто созданные переменные
        final int varOne = 1;
        final int varTwo = 1;
        final int varThree = 1;
        final int varFour = 1;

        // Переменные в "венгерской нотации", перед именем переменной
        // строчной буквой обозначен её тип
        final float fOne = 1;
        final float fTwo = 2;
        final float fThree = 3;
        final float fFour = 4.0f;

        System.out.println("Calculation from the first task gives us: " + calculate(varOne, varTwo, varThree, varFour));

        //System.out.println("Overloaded method returns: " + calculate(fOne, fTwo, fThree, fFour));

        System.out.println("Does the sum of two given numbers fit the range? " + checkTwoNumbers(1, 15));

        printIsPositive(-1);

        System.out.println("The variable in sixth task returns: " + isNegative(-1));

        printWelcome("Somename");

        System.out.println("Is the given year leap? " + isLeapYear(0));
    }
}

