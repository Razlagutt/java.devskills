package ru.ablokhin.l_404;

import java.util.Iterator;

/**
 * Created by razla on 25.04.2017.
 */
public interface ConvertIterable {
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it);
}
