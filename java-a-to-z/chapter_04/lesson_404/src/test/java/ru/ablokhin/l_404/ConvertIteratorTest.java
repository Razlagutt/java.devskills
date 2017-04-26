package ru.ablokhin.l_404;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

/**
 * Класс тестирует итератор целых чисел
 * @author Blokhin
 * @since 26.04.2017
 * @version 2
 */
public class ConvertIteratorTest {

    /**
     * Метод тестирует преобразование итератора итераторов целых чисел в один итреатор целых чисел
     */
    @Test
    public void convertTest(){
        SubIterator<Iterator<Integer>> it = new SubIterator<Iterator<Integer>>(new Iterator[]{
                        new SubIterator(new Integer[]{4, 2, 0, 4, 6, 4, 9}),
                        new SubIterator(new Integer[]{0, 9, 8, 7, 5}),
                        new SubIterator(new Integer[]{1, 3, 5, 6, 7, 0, 9, 8, 4})
                });
        Iterator<Integer> actIt = new SubIterator<Integer>(
                new Integer[]{4, 2, 0, 4, 6, 4, 9, 0, 9, 8, 7, 5, 1, 3, 5, 6, 7, 0, 9, 8, 4});
        Iterator<Integer> expIt = new ConvertIterator().convert(it);

        int i = 0;
        int[] expArr = new int[21];
        while (expIt.hasNext()){
            expArr[i++] = expIt.next();
        }

        i = 0;
        int[] actArr = new int[21];
        while (actIt.hasNext()){
            actArr[i++] = actIt.next();
        }

        assertArrayEquals(expArr, actArr);
    }
}