package ru.ablokhin.l_02;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Blokhin on 15.08.2016.
 */
public class CalculatorTest {
    @Test
    public void add() throws Exception {
        final Calculator calculator = new Calculator();
        calculator.add(10, 5);
        assertThat(calculator.result, is(15.0));
    }

    @Test
    public void substruct() throws Exception {
        final Calculator calculator = new Calculator();
        calculator.substruct(10, 5);
        assertThat(calculator.result, is(5.0));
    }

    @Test
    public void multiple() throws Exception {
        final Calculator calculator = new Calculator();
        calculator.multiple(10, 5);
        assertThat(calculator.result, is(50.0));
    }

    @Test
    public void div() throws Exception {
        final Calculator calculator = new Calculator();
        calculator.div(10, 5);
        assertThat(calculator.result, is(2.0));
    }

}