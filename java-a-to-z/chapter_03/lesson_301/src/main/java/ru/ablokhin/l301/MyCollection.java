package ru.ablokhin.l301;

import java.util.Collection;

/**
 * Класс, замеряющий время вставки и удаления большого количества случайных строк.
 * @author ablokhin
 * @since 06.05.2017
 * @version 1
 */
public class MyCollection {

    /**
     * Случайная строка
     */
    String line;

    public MyCollection(String line){
        this.line = line;
    }

    /**
     * Метод добавления большого количества случайных строк.
     * @param collection коллекция, в которую нужно вставить строки
     * @param amount число строк для вставки в коллекцию
     * @return время, затраченное на выполнение
     */
    public long add(Collection<String> collection, int amount) {
        long startTime = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            collection.add(this.line + String.valueOf(i));
        }
        long endTime = System.nanoTime();
        long difference = endTime - startTime;
        return difference;
    }

    /**
     * Метод удаления большого количества случайных строк.
     * @param collection коллекция, из которой нужно удалить строки
     * @param amount число первых строк для удаления из коллекции
     * @return время, затраченное на выполнение
     */
    public long delete(Collection<String> collection, int amount) {
        long startTime = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            collection.remove(this.line + String.valueOf(i));
        }
        long endTime = System.nanoTime();
        long difference = endTime - startTime;
        return difference;
    }
}
