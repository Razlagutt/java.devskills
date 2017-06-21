package ru.ablokhin.l301;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.TreeSet;

import static org.junit.Assert.*;

/**
 * Created by razla on 06.05.2017.
 */
public class MyCollectionTest {
    Collection<String> arrList = new ArrayList<>();
    Collection<String> linList = new LinkedList<>();
    Collection<String> tSet = new TreeSet<>();
    String line = "Add some words.";
    int amount = 100;//354836040;
    MyCollection myCollection = new MyCollection();

    @Test
    public void add() throws Exception {
        //System.out.println(myCollection.add(arrList, line, amount));
        //System.out.println(myCollection.delete(arrList, amount));
        //System.out.println(myCollection.add(linList, line, amount) + myCollection.delete(linList, amount));
        System.out.println(myCollection.add(tSet, line, amount) + myCollection.delete(tSet, amount));
    }

}