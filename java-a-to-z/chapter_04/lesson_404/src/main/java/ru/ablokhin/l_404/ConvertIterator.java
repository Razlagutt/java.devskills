package ru.ablokhin.l_404;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;

/**
 * Класс описывает итератор итераторов целых чисел
 * @author Blokhin
 * @since 24.04.2017
 * @version 1
 */
public class ConvertIterator implements ConvertIterable {


    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it){

        int len = 0;
        while (it.hasNext()){
            Iterator<Integer> it1 = it.next();
            IteratorHandler<Iterator<Integer>> iteratorHandler = new IteratorHandler<Iterator<Integer>>(it1);
            for (Iterator it2 = iteratorHandler.iterator(); it2.hasNext(); ) {
                it2.next();
                len++;
            }
        }

        return null;
    }

    //Итераторы целых чисел
    /*private SubIterator firstIt;
    private SubIterator secondIt;
    private SubIterator thirdIt;*/

    /**
     * Конструктор итератора итераторов целых чисел
     * @param firstIt итератор целых чисел
     * @param secondIt итератор целых чисел
     * @param thirdIt итератор целых чисел
     */
   /* public ConvertIterator(SubIterator firstIt, SubIterator secondIt, SubIterator thirdIt){
        this.firstIt = firstIt;
        this.secondIt = secondIt;
        this.thirdIt = thirdIt;
    }*/

    /**
     * Метод проверяет наличие следующего элемента итератора в итераторе
     * @return возвращает true, если в итераторе есть следующий элемент итератора, false в противном случае
     */
    /*@Override
    public boolean hasNext() {
        return this.firstIt.hasNext() || this.secondIt.hasNext() || this.thirdIt.hasNext();
    }*/

    /**
     * Метод возвращает целое число из итератора итераторов
     * @return возвращает целое число из итератора итераторов
     */
    /*@Override
    public Object next() {
        Object obj = null;
        if(this.firstIt.hasNext()){
            obj = this.firstIt.next();
        } else if (this.secondIt.hasNext()){
            obj = this.secondIt.next();
        } else if (this.thirdIt.hasNext()){
            obj = this.thirdIt.next();
        }
        return obj;
    }*/
}
