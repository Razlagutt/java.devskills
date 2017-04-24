package ru.ablokhin.l_404;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Класс тестирует итератор итераторов целых чисел
 * @author Blokhin
 * @since 24.04.2017
 * @version 1
 */
public class ConvertIteratorTest {

    /**
     * Метод тестирует вывод целых чисел из итератора итераторов
     */
    @Test
    public void convertIteratorTest(){
        ConvertIterator convertIterator = new ConvertIterator(
                new SubIterator(new int[]{4, 2, 0, 4, 6, 4, 9}),
                new SubIterator(new int[]{0, 9, 8, 7, 5}),
                new SubIterator(new int[]{1, 3, 5, 6, 7, 0, 9, 8, 4})
        );

        while (convertIterator.hasNext()){
            System.out.println(convertIterator.next());
        }

        assertThat(convertIterator.hasNext(), is(false));
    }
}