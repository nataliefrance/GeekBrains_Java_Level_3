package Lesson3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Main {
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        //1. Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль;
        System.out.println(Arrays.toString(main.fileToArray("D:\\Repo\\GeekBrains_Java_Level_3\\src\\Lesson3\\1.txt")));
        System.out.println(Arrays.toString(main.fileToArrayWithNio("D:\\Repo\\GeekBrains_Java_Level_3\\src\\Lesson3\\1.txt")));


        //2. Последовательно сшить 5 файлов в один (файлы примерно 100 байт).
        main.concatFiles();


        //3. Написать консольное приложение, которое умеет постранично читать текстовые файлы (размером > 10 mb).
        // Вводим страницу (за страницу можно принять 1800 символов),
        // программа выводит ее в консоль.
        // Контролируем время выполнения: программа не должна загружаться дольше 10 секунд, а чтение – занимать свыше 5 секунд.
    }



    private void concatFiles() {
        ArrayList<InputStream> list = new ArrayList<>();
        try {
            list.add(new FileInputStream("D:\\Repo\\GeekBrains_Java_Level_3\\src\\Lesson3\\2_1.txt"));
            list.add(new FileInputStream("D:\\Repo\\GeekBrains_Java_Level_3\\src\\Lesson3\\2_2.txt"));
            list.add(new FileInputStream("D:\\Repo\\GeekBrains_Java_Level_3\\src\\Lesson3\\2_3.txt"));
            list.add(new FileInputStream("D:\\Repo\\GeekBrains_Java_Level_3\\src\\Lesson3\\2_4.txt"));
            list.add(new FileInputStream("D:\\Repo\\GeekBrains_Java_Level_3\\src\\Lesson3\\2_5.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        SequenceInputStream sis = null;
        FileOutputStream fos = null;
        FileInputStream in = null;
        try {
            sis = new SequenceInputStream(Collections.enumeration(list));
            fos = new FileOutputStream("D:\\Repo\\GeekBrains_Java_Level_3\\src\\Lesson3\\2_result.txt");
            in = new FileInputStream("D:\\Repo\\GeekBrains_Java_Level_3\\src\\Lesson3\\2_result.txt");

            int x;
            while ((x = sis.read()) != -1) {
                fos.write(x);
            }

            while ((x = in.read()) != -1) {
                System.out.print((char) x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (in != null) {
                    in.close();
                }
                if (sis != null) {
                    sis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private byte[] fileToArray(String path) throws IOException {
        try (
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                InputStream in = new BufferedInputStream(new FileInputStream(path))
        ) {
            int data;
            while ((data = in.read()) != -1) {
                out.write(data);
            }
            return out.toByteArray();
        }
    }

    //Было интересно попробовать
    private byte[] fileToArrayWithNio(String path) throws IOException {
        Path p = Paths.get(path);
        byte[] array = Files.readAllBytes(p);
        return array;
    }
}
