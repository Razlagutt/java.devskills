package ru.ablokhin.l_401;

import java.util.Iterator;
/**
 * Created by Blokhin on 21.04.2017.
 */
public class MyArrayIterator implements Iterator {
    private int[][] arr;
    private int i = 0;
    private int j = 0;

    public MyArrayIterator(int[][] arr){
        this.arr = arr;
    }

    @Override
    public boolean hasNext() {
        return true;// this.arr.length > this.i;
    }

    @Override
    public Object next() {
        if(this.arr[this.i].length > this.j){
            return  this.arr[this.i][this.j++];
        } else {
            this.j = 0;
            return  this.arr[this.i++][this.j];
        }
    }
}
