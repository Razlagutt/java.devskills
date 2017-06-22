package ru.ablokhin.l301;

import java.util.Collection;

/**
 * Created by razla on 06.05.2017.
 */
public class MyCollection {

    public long add(Collection<String> collection, String line, int amount) {
        long startTime = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            collection.add(line + String.valueOf(i));
        }
        long endTime = System.nanoTime();
        long difference = endTime - startTime;
        return difference;
    }

    public long delete(Collection<String> collection, String line, int amount) {
        long startTime = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            collection.remove(line + String.valueOf(i));
        }
        long endTime = System.nanoTime();
        long difference = endTime - startTime;
        return difference;
    }
}
