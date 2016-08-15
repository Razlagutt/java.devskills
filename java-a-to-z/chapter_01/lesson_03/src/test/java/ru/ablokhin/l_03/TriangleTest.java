package ru.ablokhin.l_03;

import org.junit.Assert.*;
import org.junit.Test;
import static org.hamcrest.core.Is.is;

import static org.junit.Assert.*;

/**
 * Created by Blokhin on 15.08.2016.
 */
public class TriangleTest {
    @Test
    public void area() throws Exception {
        Point a = new Point(1, 1);
        Point b = new Point(1, 3);
        Point c = new Point(3, 2);
        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
        assertThat(result, is(2.0));
    }

    @Test
    public void maxTriangleSide() throws Exception {
        Point a = new Point(1, 1);
        Point b = new Point(1, 3);
        Point c = new Point(3, 2);
        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.maxTriangleSide();
        assertThat(result, is(2.23606797749979));
    }

}