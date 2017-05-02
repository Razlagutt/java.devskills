package ru.ablokhin.l405;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertArrayEquals;

/**
 * Класс, тестирующий методы класса контейнера данных.
 * @author Blokhin
 * @since  25.04.2017
 * @version 1
 */
public class SimpleArrayTest {

    /**
     * Метод теститрует возможность добавление объекта в контейнер.
     */
    @Test
    public void add() {
        SimpleArray<Integer> iSimpleArray = new SimpleArray<>(new Integer[1]);

        iSimpleArray.add(1);

        assertThat(iSimpleArray.get(0), is(1));
    }

    /**
     * Метод теститрует возможность изменения объекта в контейнере на другой.
     */
    @Test
    public void update() {
        SimpleArray<String> strSimpleArray = new SimpleArray<>(new String[1]);
        strSimpleArray.add("Start");

        strSimpleArray.update("Finish", 0);

        assertThat(strSimpleArray.get(0), is("Finish"));
    }

    /**
     * Метод теститрует возможность удаления объекта из контейнера.
     */
    @Test
    public void delete() {
        SimpleArray<String> strSimpleArray = new SimpleArray<>(new String[4]);
        strSimpleArray.add("a");
        strSimpleArray.add("c");
        strSimpleArray.add("b");
        strSimpleArray.add("d");
        String[] actArr = new String[]{"d"};

        strSimpleArray.delete("c");
        strSimpleArray.delete("b");
        strSimpleArray.delete("a");

        int i = 0;
        String[] expArr = new String[1];
        while (strSimpleArray.hasNext()) {
            expArr[i++] = (String) strSimpleArray.next();
        }

        assertArrayEquals(expArr, actArr);
    }

    /**
     * Метод теститрует возможность получения объекта из контейнера.
     */
    @Test
    public void get() {
        SimpleArray<Integer> iSimpleArray = new SimpleArray<>(new Integer[]{1});

        assertThat(iSimpleArray.get(0), is(1));
    }

}