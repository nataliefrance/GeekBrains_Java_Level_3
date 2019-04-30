package Lesson7.Annotations;

public class TestClass {
    @BeforeSuite
    private static void start(){
        System.out.println("Start");
    }
    @AfterSuite
    private static void end(){
        System.out.println("End");
    }

    private static void method1(){
        System.out.println("method1 without annotation");
    }
    @Test(priority = 10)
    private static void method2(){
        System.out.println("method2 with priority 10");
    }

    @Test(priority = 1)
    private static void method3(){
        System.out.println("method3 with priority 1");
    }
    @Test(priority = 7)
    private static void method4(){
        System.out.println("method4 with priority 7");
    }
    @Test
    private static void method5(){
        System.out.println("method5 with default priority");
    }
}
