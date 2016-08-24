package ru.ablokhin.l_03;

import org.junit.Assert.*;
import org.junit.Test;
import static org.hamcrest.core.Is.is;

import static org.junit.Assert.*;

/**
 * Created by Blokhin on 15.08.2016.
 */
public class PointTest {
    @Test
    public void distanceTo() throws Exception {
        Point pointA = new Point(5, 1);
        Point pointB = new Point(1, 4);

        double result = pointA.distanceTo(pointB);
        assertThat(result, is(5.0));
    }

}