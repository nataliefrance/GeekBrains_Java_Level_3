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
        System.out.println();

        //3. Написать консольное приложение, которое умеет постранично читать текстовые файлы (размером > 10 mb).
        // Вводим страницу (за страницу можно принять 1800 символов),
        // программа выводит ее в консоль.
        // Контролируем время выполнения: программа не должна загружаться дольше 10 секунд, а чтение – занимать свыше 5 секунд.
        main.readBigFile("D:\\Repo\\GeekBrains_Java_Level_3\\src\\Lesson3\\3.txt");
    }

    private void readBigFile(String name) {
        long start = System.currentTimeMillis();
        try (RandomAccessFile raf = new RandomAccessFile(name, "r"); //"r" - режим чтения
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {
            long fileLength = raf.length();
            long pageLength = 1800;
            long pagesCount = fileLength / pageLength;
            byte[] byteArray = new byte[1800];
            System.out.println("Время запуска программы: " + (System.currentTimeMillis() - start));
            while (true) {
                System.out.println("\nВведите страницу от 1 до " + pagesCount + ". Для выхода введите 0");
                int page = Integer.parseInt(reader.readLine());
                if (page <= pagesCount && page >= 0) {
                    long startSearch = System.currentTimeMillis();
                    raf.seek((page - 1) * pageLength);
                    raf.read(byteArray, 0, byteArray.length); //Считывает byteArray.length байтов в массив byteArray начиная с 0 места
                    for (byte b : byteArray) {
                        System.out.print((char) b);
                    }
                    System.out.println();
                    System.out.println("Время поиска: " + (System.currentTimeMillis() - startSearch) + " миллисекунд.");
                } else if (page == 0) {
                    System.out.println("Досвидули!");
                    break;
                } else {
                    System.out.println("Такой страницы не существует.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
