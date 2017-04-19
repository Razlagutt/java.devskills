package ru.ablokhin.l_013.models;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Класс для проверки метода way()
 * @author ablokhin
 * @since 31.03.2017
 * @version 1
 */
public class BishopTest {
    /**
     * Метод для проверки метода way()
     * @throws ImpossibleMoveException исключение в случае не возможности переместить фигуру Слон в заданную клетку
     */
    @Test
    public void way() throws ImpossibleMoveException {

        //Массив клеток
        Cell[] cells = new Cell[]{
            //Начальное положение фигуры
            new Cell(1, 1),
            //Координаты для перемещения
            new Cell(5, 5)
        };

        Bishop bishop = new Bishop(cells[0]);
        Cell[] checkCells = bishop.way(cells[1]);
        assertThat(cells[1].getHorizontal(), is(checkCells[3].getHorizontal()));
    }
}