package ru.ablokhin.l_401;

import java.util.Iterator;
/**
 * Created by Blokhin on 21.04.2017.
 */
public class MyArrayIterator {
    Iterator<int> iterator = new Iterator<int>(int[][]{{1,2},{3,4}}) {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public int next() {
            return 0;
        }
    };
}
