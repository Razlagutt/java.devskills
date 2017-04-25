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
        boolean isNext = false;
        while (this.eNum.length > this.i){
            if (this.eNum[this.i] % 2 == 0){
                isNext = true;
                break;
            } else {
                this.i++;
            }
        }
        return isNext;
    }

    /**
     * Метод возвращает четное число из массива
     * @return возвращает четное число из массива
     */
    @Override
    public Object next(){
        return this.eNum[this.i++];
    }
}
