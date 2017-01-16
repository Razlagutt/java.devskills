package ru.ablokhin.l_012.start;

/**
 * Interface UserAction описывает методы дейсвия пользователя
 * @author ablokhin
 * @since 15.01.2017
 * @version 1
 */
public interface UserAction {

    /**
    * Метод key возвращает ключ действия пользователя
    */
    int key();

    /**
     * Метод execute осуществляет действие пользователя
     * @param input ввод пользователя
     * @param tracker трекер с заявками
    */
    void execute(Input input, Tracker tracker);

    /**
    * Метод info сообщает о выбранном действии пользователя
    */
    String info();
}
