package ru.ablokhin.l_05;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Andrey on 15.08.2016.
 */
public class ArrayRotationTest {
    @Test
    public void rotate() throws Exception {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        ArrayRotation arrayRotation = new ArrayRotation(arr);
        int[][] result = arrayRotation.rotate();
        int[][] checked = {
                {3, 6, 9},
                {2, 5, 8},
                {1, 4, 7}
        };
        assertThat(result, is(checked));
    }

}