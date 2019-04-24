package Lesson6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class MainTestParam {

    @Parameterized.Parameters
    public static Collection<Object[][]> data() {
        return Arrays.asList(new Object[][][]{
                        {{1, 2, 4, 2, 3, 8}, {2, 3, 8}},
                        {{1, 2, 4, 2, 3, 8, 4, 3, 5, 7}, {3, 5, 7}},
                        {{4, 2, 3, 8, 1}, {2, 3, 8, 1}},
                }
        );
    }

    private int[] inputArray;
    private Integer[] expected;

    public MainTestParam(Object[] inputArrayObject, Object[] expectedObject) {
        int[] inputArrayRes = new int[inputArrayObject.length];
        Integer[] expectedRes = new Integer[expectedObject.length];

        for (int i = 0; i < inputArrayObject.length; i++) {
            inputArrayRes[i] = Integer.parseInt(String.valueOf(inputArrayObject[i]));
        }

        for (int i = 0; i < expectedObject.length; i++) {
            expectedRes[i] = Integer.parseInt(String.valueOf(expectedObject[i]));
        }

        this.inputArray = inputArrayRes;
        this.expected = expectedRes;
    }

    private Main main;

    @Test
    public void testAfterFour() {
        Assert.assertArrayEquals(expected, main.afterFour(inputArray));
    }

    @Before
    public void init() {
        main = new Main();
    }
}