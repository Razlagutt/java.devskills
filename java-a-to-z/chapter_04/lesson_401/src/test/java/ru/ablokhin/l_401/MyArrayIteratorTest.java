package ru.ablokhin.l_401;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by razla on 22.04.2017.
 */
public class MyArrayIteratorTest {

    @Test
    public void my2DArrayTest(){
        MyArrayIterator it = new MyArrayIterator(new int[][]{{1,2},{3,4}});
        boolean r = it.hasNext();
        while(r){
            System.out.println(it.next());
            r = it.hasNext();
        }
        //assertThat(it.hasNext(), is(false));
    }
}