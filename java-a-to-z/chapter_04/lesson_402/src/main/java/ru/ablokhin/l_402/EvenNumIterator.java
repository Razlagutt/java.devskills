package ru.ablokhin.l_402;

import java.util.Iterator;

/**
 * Класс описывает итератор четных чисел
 * @author Blokhin
 * @since 24.04.2017
 * @version 1
 */
public class EvenNumIterator implements Iterator {

    //Массив целых чисел
    private int[] eNum = new int[10];
    //Индекс массива
    private int i = 0;

    /**
     * Конструктор итератора
     * @param eNum массив целых чисел
     */
    public EvenNumIterator(int[] eNum){
        this.eNum = eNum;
    }

    /**
     * Метод проверяет наличие следующего элемента в массиве
     * @return возвращает true, если в массиве есть следующий элемент, false в противном случае
     */
    @Override
    public boolean hasNext(){
        return this.eNum.length - 1 > this.i;
    }

    /**
     * Метод возвращает четный элемент массива
     * @return возвращает четный элемент массива
     */
    @Override
    public Object next(){
        int evenNum = 0;
        while (this.eNum[this.i++] % 2 != 0){
            evenNum = this.eNum[this.i++];
            break;
        }
        return evenNum;
    }
}
