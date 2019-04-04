package Lesson3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        //1. Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль;
        System.out.println(Arrays.toString(main.fileToArray("1.txt")));
        System.out.println(Arrays.toString(main.fileToArrayWithNio("1.txt")));


        //2. Последовательно сшить 5 файлов в один (файлы примерно 100 байт).
        // Может пригодиться следующая конструкция:
        // ArrayList<InputStream> al = new ArrayList<>(); ... Enumeration<InputStream> e = Collections.enumeration(al);

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
