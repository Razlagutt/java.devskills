package ru.ablokhin.l_013.models;

/**
 * Дочерний класс для определения исключения в случае, если клетка не занята фигурой
 * @author ablokhin
 * @since 31.03.2017
 * @version 1
 */
public class FigureNotFoundException extends Exception {

    /**
     * Конструктор исключения
     * @param msg сообщение о возникновении исключителнной ситуации
     */
    public FigureNotFoundException(String msg){
        super(msg);
    }
}
