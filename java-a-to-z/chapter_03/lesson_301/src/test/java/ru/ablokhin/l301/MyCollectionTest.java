package ru.ablokhin.l301;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * Created by razla on 06.05.2017.
 */
public class MyCollectionTest {
    Collection<String> arrList = new ArrayList<>();
    Collection<String> linList = new LinkedList<>();
    Collection<String> tSet = new TreeSet<>();
    String line = "Что такое Lorem Ipsum";
    int amountToAdd = 99999;//354836040;
    int amountToDel = 99999;
    MyCollection myCollection = new MyCollection();

    @Test
    public void performanceTest() throws Exception {
        String strFormatAmount = String.format("Время вставки в коллекцию %s случайных строк составило:", amountToAdd);
        String stringFormatArrayList = String.format("ArrayList = %d мс.", myCollection.add(arrList, line, amountToAdd));
        String stringFormatLinkedList = String.format("LinkedList = %d мс.", myCollection.add(linList, line, amountToAdd));
        String stringFormatTreeSet = String.format("TreeSet = %d мс.", myCollection.add(tSet, line, amountToAdd));

        System.out.println(strFormatAmount);
        System.out.println(stringFormatArrayList);
        System.out.println(stringFormatLinkedList);
        System.out.println(stringFormatTreeSet);
        System.out.println("------------------------");

        strFormatAmount = String.format("Время удаления из коллекции %s случайных строк составило:", amountToDel);
        stringFormatArrayList = String.format("ArrayList = %d мс.", myCollection.delete(arrList, line, amountToDel));
        stringFormatLinkedList = String.format("LinkedList = %d мс.", myCollection.delete(linList, line, amountToDel));
        stringFormatTreeSet = String.format("TreeSet = %d мс.", myCollection.delete(tSet, line, amountToDel));

        System.out.println(strFormatAmount);
        System.out.println(stringFormatArrayList);
        System.out.println(stringFormatLinkedList);
        System.out.println(stringFormatTreeSet);
        System.out.println("------------------------");
    }

}