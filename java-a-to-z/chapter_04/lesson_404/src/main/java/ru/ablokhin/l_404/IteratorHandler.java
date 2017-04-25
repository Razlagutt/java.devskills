package ru.ablokhin.l_404;

import java.util.Iterator;

/**
 * Created by razla on 25.04.2017.
 */
public class IteratorHandler<E> implements Iterable {

    private Iterator<Integer> it;

    public IteratorHandler(Iterator<Integer> it){
        this.it = it;
    }

    @Override
    public Iterator iterator() {
        return it;
    }
}
