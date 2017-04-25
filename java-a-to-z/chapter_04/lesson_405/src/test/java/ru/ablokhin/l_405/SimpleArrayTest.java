package ru.ablokhin.l_405;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Класс, тестирующий методы класса контейнера данных
 * @author Blokhin
 * @since  25.04.2017
 * @version 1
 */
public class SimpleArrayTest {

    /**
     * Метод теститрует возможность добавление объекта в контейнер
     * @throws Exception
     */
    @Test
    public void add() throws Exception {
        SimpleArray<Integer> iSimpleArray = new SimpleArray<>(new Integer[1]);

        iSimpleArray.add(1);

        assertThat(iSimpleArray.get(0), is(1));
    }

    /**
     * Метод теститрует возможность изменения объекта в контейнере на другой
     * @throws Exception
     */
    @Test
    public void update() throws Exception {
        SimpleArray<String> strSimpleArray = new SimpleArray<>(new String[]{"Start"});

        strSimpleArray.update("Finish", 0);

        assertThat(strSimpleArray.get(0), is("Finish"));
    }

    /**
     * Метод теститрует возможность удаления объекта из контейнера
     * @throws Exception
     */
    @Test
    public void delete() throws Exception {
        SimpleArray<String> strSimpleArray = new SimpleArray<>(new String[]{"a", "c", "b"});

        strSimpleArray.delete("c");

        assertNull(strSimpleArray.get(2));
    }

    /**
     * Метод теститрует возможность получения объекта из контейнера
     * @throws Exception
     */
    @Test
    public void get() throws Exception {
        SimpleArray<Integer> iSimpleArray = new SimpleArray<>(new Integer[]{1});

        assertThat(iSimpleArray.get(0), is(1));
    }

}