package ru.ablokhin.l_06;

import org.junit.Test;
//import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Andrey on 15.08.2016.
 */
public class SubstringSearcherTest {
    @Test
    public void contains() throws Exception {
        String origin = "You got no gggggguts!";
        String sub = "guts!";
        SubstringSearcher substringSearcher = new SubstringSearcher();
        boolean result = substringSearcher.contains(origin, sub);
        assertTrue(result);
    }
}