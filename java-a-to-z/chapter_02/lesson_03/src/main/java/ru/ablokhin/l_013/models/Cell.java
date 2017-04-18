package ru.ablokhin.l_013.models;

/**
 * Класс для определения клетки шахматной доски
 * @author ablokhin
 * @since 31.03.2017
 * @version 1
 */
public class Cell {
    //Координаты по вертикали
    private int vertical;
    //Координаты по горизонтали
    private int horizontal;

    /**
     * Конструктор клетки
     * @param vertical координаты по вертикали
     * @param horizontal координаты по горизонтали
     */
    public Cell(int vertical, int horizontal){
        this.vertical = vertical;
        this.horizontal = horizontal;
    }

    /**
     * Метод получения координаты по горизонтали
     * @return возвращает координату по горизонтали
     */
    protected int getHorizontal() {
        return horizontal;
    }

    /**
     * Метод получения координаты по вертикали
     * @return возвращает координату по вертикали
     */
    protected int getVertical() {
        return vertical;
    }

    /**
     *Метод проверяет клетку на занятость фигурой
     * @param figures фигуры, которые потенциально могут занимать эту клетку
     * @return возвращает фигуру, которая занимает эту клетку
     * @throws FigureNotFoundException исключение в случае, если клетка не занята фигурой
     */
    protected Figure isNotFilledWith(Figure[] figures) throws FigureNotFoundException{
        Figure foundTheFigure = null;
        for (Figure figure : figures) {
            if(figure != null &&
                    figure.position.getHorizontal() == this.getHorizontal() &&
                    figure.position.getVertical() == this.getVertical() ){
                foundTheFigure = figure;
                break;
            }
        }
        return foundTheFigure;
    }
}
