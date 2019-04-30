package Lesson7;

import java.io.File;
import java.lang.reflect.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

public class CheckHomeWork {

    public static void main(String[] args) {
        CheckHomeWork checkHW = new CheckHomeWork();
        try {
            checkHW.check();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void check() throws Exception {

        File file = new File("D:/111");
        String[] fileList = file.list();

        ArrayList<String> fileName = new ArrayList<String>();

        for (String o : fileList) {
            String[] mass = o.split("\\.");
            if (mass[1].equalsIgnoreCase("class")) {
                fileName.add(mass[0]);
            }
        }

        for (String s : fileName) {
            String name = String.valueOf(s);
            Class cl = URLClassLoader.newInstance(new URL[]{new File("D:/111").toURL()})
                    .loadClass(name);
            Constructor constructor = cl.getConstructor();
            Object readyHomeWork = constructor.newInstance();

            Method calculate = cl.getDeclaredMethod("calculate", int.class, int.class, int.class, int.class);
            calculate.setAccessible(true);
            int result1 = (Integer) calculate.invoke(readyHomeWork, 1, 1, 1, 1);
            System.out.println(result1);

            Method checkTwoNumbers = cl.getDeclaredMethod("checkTwoNumbers", int.class, int.class);
            checkTwoNumbers.setAccessible(true);
            boolean result2 = (Boolean) checkTwoNumbers.invoke(readyHomeWork, 10, 5);
            System.out.println(result2);

            Method isNegative = cl.getDeclaredMethod("isNegative", int.class);
            isNegative.setAccessible(true);
            boolean result3 = (Boolean) isNegative.invoke(readyHomeWork, -10);
            System.out.println(result3);

            Method isLeapYear = cl.getDeclaredMethod("isLeapYear", int.class);
            isLeapYear.setAccessible(true);
            boolean result4 = (Boolean) isLeapYear.invoke(readyHomeWork, 2020);
            System.out.println(result4);

            if (result1 == 2 && result2 && result3 && result4) {
                System.out.println(name + " Passed");
            } else {
                System.out.println(name + " Failed");
            }
        }
    }
}