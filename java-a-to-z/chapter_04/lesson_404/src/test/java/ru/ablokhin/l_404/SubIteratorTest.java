package ru.ablokhin.l_404;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Класс тестирует итератор целых чисел
 * @author Blokhin
 * @since 24.04.2017
 * @version 1
 */
public class SubIteratorTest {

    /**
     * Метод тестирует вывод целых чисел из массива
     */
    @Test
    public void subIteratorTest(){
        SubIterator subIterator = new SubIterator(new int[]{1,2,3,4,5});

        while (subIterator.hasNext()){
            System.out.println(subIterator.next());
        }

        assertThat(subIterator.hasNext(), is(false));
    }

}