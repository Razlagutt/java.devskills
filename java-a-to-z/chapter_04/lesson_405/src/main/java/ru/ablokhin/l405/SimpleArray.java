package ru.ablokhin.l405;

import java.util.Iterator;

/**
 * Обощенный класс, описывающий контейнер данных.
 * @author Blokhin
 * @since  25.04.2017
 * @param <T>
 * @version 1
 */
public class SimpleArray<T> implements Iterator {

    /**
     * Обощенный массив.
     */
    private T[] arr;

    /**
     * Индекс массива.
     */
    private int index;

    /**
     * Конструктор контейнера данных.
     * @param arr массив данных
     */
    public SimpleArray(T[] arr) {
        this.arr = arr;
    }

    /**
     * Метод добавляет объект в контейнер.
     * @param obj объект для добавления в контейнер
     */
    protected void add(T obj) {
        this.arr[this.index++] = obj;
    }

    /**
     * Метод, изменяющий объект в контейнере по индексу.
     * @param obj объект, которым нужно заменить объект в контецнере
     * @param index индекс объекта в контейнере, подлежащий изменению на obj
     */
    protected void update(T obj, int index) {
        this.arr[index] = obj;
    }

    /**
     * Метод удаления объекта из контейнера.
     * @param obj объект, который нужно удалить из контейнера
     */
    protected void delete(T obj) {
        for (int i = 0; i < this.arr.length; i++) {
            if (this.arr[i] != null && this.arr[i].equals(obj)) {
                System.arraycopy(this.arr, i + 1, this.arr, i, this.arr.length - i - 1);
                this.arr[this.arr.length - 1] = null;
                break;
            }
        }
    }

    /**
     * Метод получения объекта по индексу.
     * @param index объекта в контейнере
     * @return возращает объект по индексу
     */
    protected T get(int index) {
        return this.arr[index];
    }

    /**
     * Метод проверяет наличие следующего элемента в массиве.
     * @return возвращает true, если в массиве есть следующий элемент, false в противном случае
     */
    @Override
    public boolean hasNext() {
        return this.arr.length > this.index && this.arr[index] != null;
    }

    /**
     * Метод возвращает целое число из массива.
     * @return возвращает целое число из массива
     */
    @Override
    public Object next() {
        return this.arr[index++];
    }
}
