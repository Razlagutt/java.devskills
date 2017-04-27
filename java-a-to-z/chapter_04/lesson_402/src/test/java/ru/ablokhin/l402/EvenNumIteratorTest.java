package ru.ablokhin.l402;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс описывает тест итератора четных чисел.
 * @author Blokhin
 * @since 24.04.2017
 * @version 1
 */
public class EvenNumIteratorTest {

    /**
     * Метод тестирует итератор на вывод только четных чисел.
     */
    @Test
    public void returnEvenNumsOnlyTest() {
        EvenNumIterator evenNumIterator = new EvenNumIterator(new int[]{2, 3, 4, 5, 6, 8, 9, 10, 11, 12, 24, 25});

        while (evenNumIterator.hasNext()) {
            System.out.println(evenNumIterator.next());
        }

        assertThat(evenNumIterator.hasNext(), is(false));
    }
}