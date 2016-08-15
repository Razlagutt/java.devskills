package ru.ablokhin.l_04;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Blokhin on 15.08.2016.
 */
public class FactorialTest {
    @Test
    public void calculate() throws Exception {
        Factorial factorial = new Factorial(3);
        double result = factorial.calculate();
        assertThat(result, is(6.0));
    }

}