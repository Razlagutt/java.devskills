package ru.ablokhin.l_404;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Класс описывает преобразование итератора итераторов целых чисел в один итреатор целых чисел
 * @author Blokhin
 * @since 26.04.2017
 * @version 2
 */
public class ConvertIterator implements ConvertIterable {

    /**
     * Метод преобразовывает итератор итераторов целых чисел в один итреатор целых чисел
     * @param it итератор итераторов целых чисел
     * @return итератор целых чисел
     */
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it){
        ArrayList<Integer> al = new ArrayList<Integer>();
        while (it.hasNext()){
            Iterator<Integer> itInteger = it.next();
            while (itInteger.hasNext()){
                al.add(new Integer(itInteger.next().toString()));
            }
        }
        return new SubIterator<Integer>(al.toArray(new Integer[al.size()]));
    }
}
