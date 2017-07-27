package ru.ablokhin.l301;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * Класс замеряет время вставки и удаления большого количества случайных строк.
 * @author ablokhin
 * @since 06.05.2017
 * @version 1
 */
public class MyCollectionTest {

    Collection<String> arrList = new ArrayList<>();
    Collection<String> linList = new LinkedList<>();
    Collection<String> tSet = new TreeSet<>();
    int amountToAdd = 99999;//354836040;
    int amountToDel = 99999;
    MyCollection myCollection = new MyCollection("Что такое Lorem Ipsum");

    /**
     * Метод добавления большого количества случайных строк.
     * @param myCollection объект, содержащий случайную строку
     * @param amountToAdd число строк для вставки в коллекцию
     * @param collection коллекция, в которую нужно вставить строки
     * @return коллекцию случайных строк
     */
    public Collection<String> addToCollection(MyCollection myCollection, int amountToAdd, Collection<String> collection){
        for (int i = 0; i < amountToAdd; i++) {
            collection.add(myCollection.line + String.valueOf(i));
        }
        return collection;
    }

    /**
     * Метод замеряет время вставки и удаления большого количества случайных строк.
     * @throws Exception
     */
    @Test
    public void performanceTest() throws Exception {
        String strFormatAmount = String.format("Время вставки в коллекцию %s случайных строк составило:", amountToAdd);
        String stringFormatArrayList = String.format("ArrayList = %d мс.", myCollection.add(arrList, amountToAdd));
        String stringFormatLinkedList = String.format("LinkedList = %d мс.", myCollection.add(linList, amountToAdd));
        String stringFormatTreeSet = String.format("TreeSet = %d мс.", myCollection.add(tSet, amountToAdd));

        System.out.println(strFormatAmount);
        System.out.println(stringFormatArrayList);
        System.out.println(stringFormatLinkedList);
        System.out.println(stringFormatTreeSet);
        System.out.println("------------------------");

        strFormatAmount = String.format("Время удаления из коллекции %s случайных строк составило:", amountToDel);
        stringFormatArrayList = String.format("ArrayList = %d мс.",
                myCollection.delete(this.addToCollection(myCollection, amountToAdd, arrList), amountToDel));
        stringFormatLinkedList = String.format("LinkedList = %d мс.",
                myCollection.delete(this.addToCollection(myCollection, amountToAdd, linList), amountToDel));
        stringFormatTreeSet = String.format("TreeSet = %d мс.",
                myCollection.delete(this.addToCollection(myCollection, amountToAdd, tSet), amountToDel));

        System.out.println(strFormatAmount);
        System.out.println(stringFormatArrayList);
        System.out.println(stringFormatLinkedList);
        System.out.println(stringFormatTreeSet);
        System.out.println("------------------------");
    }

}