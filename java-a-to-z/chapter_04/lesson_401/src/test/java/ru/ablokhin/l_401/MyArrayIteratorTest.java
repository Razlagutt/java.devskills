package ru.ablokhin.l_401;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Класс для тестирования итератора двумерного массива
 * @author ablokhin
 * @since 24.04.2017
 * @version 1
 */
public class MyArrayIteratorTest {

    /**
     * Метод для тестирования итератора двумерного массива
     */
    @Test
    public void my2DArrayTest(){
        MyArrayIterator it = new MyArrayIterator(new int[][]{{1,2},{3,4}});

        while(it.hasNext()){
            System.out.println(it.next());
        }

        assertThat(it.hasNext(), is(false));
    }
}