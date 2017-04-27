package ru.ablokhin.l404;

import java.util.Iterator;

/**
 * Класс описывает итератор целых чисел.
 * @author Blokhin
 * @since 26.04.2017
 * @param <E>
 * @version 2
 */
public class SubIterator<E> implements Iterator {

    /**
     * Массив целых чисел.
     */
    private E[] values;

    /**
     * Индекс массива целых чисел.
     */
    private int i = 0;

    /**
     * Конструктор итератора целых чисел.
     * @param values массив целых чисел
     */
    public SubIterator(E[] values) {
        this.values = values;
    }

    /**
     * Метод проверяет наличие следующего элемента в массиве.
     * @return возвращает true, если в массиве есть следующий элемент, false в противном случае
     */
    @Override
    public boolean hasNext() {
        return this.values.length > this.i;
    }

    /**
     * Метод возвращает целое число из массива.
     * @return возвращает целое число из массива
     */
    @Override
    public Object next() {
        return this.values[i++];
    }
}