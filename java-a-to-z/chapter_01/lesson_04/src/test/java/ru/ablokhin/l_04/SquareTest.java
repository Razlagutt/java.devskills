package ru.ablokhin.l_04;

import org.junit.Test;
import static org.hamcrest.core.Is.is;

import static org.junit.Assert.*;

/**
 * Created by Blokhin on 15.08.2016.
 */
public class SquareTest {
    @Test
    public void calculate() throws Exception {
        double[] tst = new double[]{-3.0, -1.0};
        Square square = new Square(1, 4, 3);
        double[] result = square.calculate();
        assertThat(result, is(tst));
    }

}