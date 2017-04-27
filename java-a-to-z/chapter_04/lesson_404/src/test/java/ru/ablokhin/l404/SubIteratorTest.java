package ru.ablokhin.l404;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс для тестирования корректной работы основных методов итератора.
 * @author Blokhin
 * @since 26.04.2017
 * @version 2
 */
public class SubIteratorTest {

    /**
     * Метод тестирует работу основных методов (hasNext(), next()) итератора.
     */
    @Test
    public void iteratorTest() {
        SubIterator<Integer> it = new SubIterator<Integer>(new Integer[]{4, 2, 0, 4, 6, 4, 9});

        while (it.hasNext()) {
            System.out.println(it.next());
        }

        assertThat(it.hasNext(), is(false));
    }
}