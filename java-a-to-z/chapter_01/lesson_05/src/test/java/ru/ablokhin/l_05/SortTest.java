package ru.ablokhin.l_05;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Andrey on 15.08.2016.
 */
public class SortTest {
    @Test
    public void sort() throws Exception {
        Sort bubbleSort = new Sort(new int[]{9, 7, 3, 1, 6, 4, 8, 2, 5});
        assertThat(bubbleSort.sort(), is(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }
}