package ru.ablokhin.l_403;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Класс тестирует итератор простых чисел
 * @author Blokhin
 * @since 24.04.2017
 * @version 1
 */
public class PrimeNumsIteratorTest {

    /**
     * Метод проверяет итератор на вывод только простых чисел из массива
     */
    @Test
    public void returnPrimeNumsTest(){
        PrimeNumsIterator primeNumsIterator = new PrimeNumsIterator(new int[]{
                1,2,3,4,5,6,7,8,9,10,
                11,12,13,14,15,16,17,18,19,20,
                21,22,23,24,25,26,27,28,29,30
        });

        while (primeNumsIterator.hasNext()){
            System.out.println(primeNumsIterator.next());
        }

        assertThat(primeNumsIterator.hasNext(), is(false));
    }
}