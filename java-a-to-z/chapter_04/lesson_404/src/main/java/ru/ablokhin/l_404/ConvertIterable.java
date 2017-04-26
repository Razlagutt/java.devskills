package ru.ablokhin.l_404;

import java.util.Iterator;

/**
 * Интерфейс определяет метод преобразования итератора итераторов целых чисел в один итреатор целых чисел
 * @author Blokhin
 * @since 26.04.2017
 * @version 2
 */
public interface ConvertIterable {

    /**
     * Метод преобразования итератора итераторов целых чисел в один итреатор целых чисел
     * @param it итератор итераторов целых чисел
     * @return итератор целых чисел
     */
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it);
}
