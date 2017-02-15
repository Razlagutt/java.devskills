package ru.ablokhin.l_012.start;

/**
 * Class BaseAction описывает базовые методы дейсвия пользователя
 * @author ablokhin
 * @since 15.02.2017
 * @version 1
 */
public abstract class BaseAction implements UserAction {

    private String name;

    public BaseAction(String name){
        this.name = name;
    }

    /**
     * Метод key возвращает ключ действия пользователя
     */
    public abstract int key();

    /**
     * Метод execute осуществляет действие пользователя
     * @param input ввод пользователя
     * @param tracker трекер с заявками
     */
    public abstract void execute(Input input, Tracker tracker);

    /**
     * Метод info сообщает о выбранном действии пользователя
     * @return возвращает ключ и название выбранного действия
     */
    public String info(){
        return String.format("%s. %s", this.key(), this.name);
    }
}
