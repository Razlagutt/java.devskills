package ru.ablokhin.l_403;

import java.util.Iterator;

/**
 * Класс описывает итератор простых чисел
 * @author Blokhin
 * @since 24.04.2017
 * @version 1
 */
public class PrimeNumsIterator implements Iterator {

    //Массив целых чисел
    private int[] pNums = new int[30];
    //Индекс массива целых чисел
    private int i = 0;

    /**
     * Конструктор итератора простых чисел
     * @param pNums массив целых чисел
     */
    public PrimeNumsIterator(int[] pNums){
        this.pNums = pNums;
    }

    /**
     * Метод проверяет наличие следующего элемента в массиве
     * @return возвращает true, если в массиве есть следующий элемент, false в противном случае
     */
    @Override
    public boolean hasNext() {
        return this.pNums.length - 1 > this.i;
    }

    /**
     * Метод возвращает простое число из массива
     * @return возвращает простое число из массива
     */
    @Override
    public Object next() {
        boolean isPrimeNum = false;
        int primeNum = 0;
        if (this.pNums[i] == 0 || this.pNums[i] == 1 || this.pNums[i] == 2){
            primeNum = this.pNums[i++];
        }else {
            while (this.pNums.length > this.i){
                for(int j = 2; j <= this.pNums[i]; j++){
                    if (this.pNums[i] % j == 0 && this.pNums[i] > j){
                        this.i++;
                        break;
                    }
                    if(this.pNums[i] % j == 0 && this.pNums[i] == j){
                        primeNum = this.pNums[i++];
                        isPrimeNum = true;
                        break;
                    }
                }
                if(isPrimeNum){
                    break;
                }
            }
        }
        return primeNum;
    }
}
