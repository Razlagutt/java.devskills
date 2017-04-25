package ru.ablokhin.l_404;

import org.junit.Test;

import java.util.Iterator;

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
        //SubIterator<Integer[]> subIterator = new SubIterator(new Integer[]{1,2,3,4,5});
        SubIterator<Iterator<Integer>> itt = new SubIterator<Iterator<Integer>>(new Iterator[]{
                        new SubIterator(new Integer[]{4, 2, 0, 4, 6, 4, 9}),
                        new SubIterator(new Integer[]{0, 9, 8, 7, 5}),
                        new SubIterator(new Integer[]{1, 3, 5, 6, 7, 0, 9, 8, 4})
                });

        //ConvertIterator it = new ConvertIterator();
        Iterator<Integer> convIt = new ConvertIterator().convert(itt);

        while (convIt.hasNext()){
            System.out.println(convIt.next());
        }

        assertThat(convIt.hasNext(), is(false));
    }
}