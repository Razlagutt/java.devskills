package ru.ablokhin.l_013.models;

/**
 * Дочерний класс для определения исключения в случае не возможности переместить фигуру в заданную клетку
 * @author ablokhin
 * @since 31.03.2017
 * @version 1
 */
public class OccupiedWayException extends Exception {

    /**
     * Конструктор исключения
     * @param msg сообщение о возникновении исключителнной ситуации
     */
    public OccupiedWayException(String msg){
        super(msg);
    }
}
