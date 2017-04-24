package ru.ablokhin.l_401;

import java.util.Iterator;

/**
 * Класс для определения итератора двумерного массива
 * @author ablokhin
 * @since 24.04.2017
 * @version 1
 */
public class MyArrayIterator implements Iterator {

    //Двумерный массивж
    private int[][] arr;

    //Индекс строк массива
    private int i = 0;
    //Индекс столбцов массива
    private int j = 0;

    /**
     * Конструктор итератора
     * @param arr принимает двумерный массив
     */
    public MyArrayIterator(int[][] arr){
        this.arr = arr;
    }

    /**
     * Метод проверяет наличие следующего элемента в итераторе
     * @return возвращает true, если следующий элемент в итераторе есть. false в противном случае
     */
    @Override
    public boolean hasNext() {
        return this.arr.length - 1 > this.i || this.arr[this.i].length > this.j;
    }

    /**
     * Метод возвращает текущий элемент итератора
     * @return возвращает текущий элемент итератора
     */
    @Override
    public Object next() {
        if(this.arr[this.i].length > this.j){
            return  this.arr[this.i][this.j++];
        } else {
            this.j = 0;
            return  this.arr[++this.i][this.j++];
        }
    }
}
