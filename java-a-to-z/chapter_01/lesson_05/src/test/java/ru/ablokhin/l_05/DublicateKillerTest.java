package ru.ablokhin.l_05;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Andrey on 15.08.2016.
 */
public class DublicateKillerTest {
    @Test
    public void kill() throws Exception {
        String[] arr = new String[]{"1", "1", "2", "1", "3", "1", "4", "1", "5",
                "1", "6", "1", "7", "1", "8", "1", "9", "2"};
        DublicateKiller dublicateKiller = new DublicateKiller(arr);
        String[] result = dublicateKiller.kill();
        String[] checked = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9",
                "", "", "", "", "", "", "", "", ""};
        assertThat(result, is(checked));
    }

}