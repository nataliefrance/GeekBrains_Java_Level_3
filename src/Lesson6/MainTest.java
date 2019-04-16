package Lesson6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MainTest {

    private Main main;

    @Before
    public void init(){
        main = new Main();
    }

    @Test
    public void testAfterFour() {
        int[] arrayToTest = {1, 2, 4, 4, 2, 3, 4, 1, 7, 8};
        Integer[] expected = {1, 7, 8};
        Assert.assertArrayEquals(expected, main.afterFour(arrayToTest));
    }

    @Test
    public void testHasOneOrFour() {
        int[] array1 = {1, 2, 4, 4, 2, 3, 4, 1, 7, 8};
        int[] array2 = {2, 2, 3, 7, 8};
        int[] array3 = {1, 7, 8};
        Assert.assertEquals(true, main.hasOneOrFour(array1));
        Assert.assertEquals(false, main.hasOneOrFour(array2));
        Assert.assertEquals(true, main.hasOneOrFour(array3));
    }
}