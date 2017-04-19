package ru.ablokhin.l_013.models;

/**
 * Класс для определения шахматной фигуры
 * @author ablokhin
 * @since 31.03.2017
 * @version 1
 */
public abstract class Figure{

    //Изначальная позиция фигуры на шахматной доске
    final Cell position;

    /**
     * Конструктор фигуры
     * @param position изначальная позиция фигуры на шахматной доске
     */
    protected Figure(Cell position){
        this.position = position;
    }

    /**
     * Метод проверяет возможность переместить фигуру в заданную клетку
     * @param dist клетка, куда надо переместить фигуру
     * @return массив клеток, по которым будет перемещаться фигура
     * @throws ImpossibleMoveException исключение в случае не возможности переместить фигуру в заданную клетку
     */
    protected abstract Cell[] way(Cell dist) throws ImpossibleMoveException;

    /**
     * Метод перемещает фигуру в заданную клетку
     * @param cell заданная клетка для перемещения
     * @return возвращает фигуру с новым местоположением на доске
     */
    protected abstract Figure clone(Cell cell);
}