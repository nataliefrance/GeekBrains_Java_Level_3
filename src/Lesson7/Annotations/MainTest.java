package Lesson7.Annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainTest {
    public static void main(String[] args) {
        try {
            start(TestClass.class);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    private static void start(Class testingClass) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = testingClass.getDeclaredMethods();
        for (Method method: methods) {
            method.setAccessible(true);
        }
        List<Method> listofMethods = new ArrayList<>();

        for (Method method: methods) {
            if(method.isAnnotationPresent(Test.class)){
                int priority = method.getAnnotation(Test.class).priority();
                if (priority < 1 || priority > 10) throw new RuntimeException("uncorrect priority");
                listofMethods.add(method);
            }
        }

        listofMethods.sort(new Comparator<Method>() {
            @Override
            public int compare(Method o1, Method o2) {
                return o2.getAnnotation(Test.class).priority() - o1.getAnnotation(Test.class).priority();
            }
        });

        for (Method method: methods) {
            if(method.isAnnotationPresent(BeforeSuite.class)){
                if (listofMethods.get(0).isAnnotationPresent(BeforeSuite.class)) throw new RuntimeException("BeforeSuite already exists");
                listofMethods.add(0, method);
            }
        }

        for (Method method: methods) {
            if(method.isAnnotationPresent(AfterSuite.class)){
                if (listofMethods.get(listofMethods.size() - 1).isAnnotationPresent(AfterSuite.class)) throw new RuntimeException("AfterSuite already exists");
                listofMethods.add(method);
            }
        }

        for (Method method: listofMethods) {
            method.invoke(null);
        }
    }
}
