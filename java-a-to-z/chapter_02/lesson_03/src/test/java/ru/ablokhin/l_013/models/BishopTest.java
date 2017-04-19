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
        Cell[] cellsArr = new Cell[]{
            new Cell(2, 2),
            new Cell(3, 3),
            new Cell(4, 4),
            new Cell(5, 5)
        };

        Cell cell = new Cell(1,1);
        Cell cell1 = new Cell(5,5);
        Bishop bishop = new Bishop(cell);
        Cell[] cells = bishop.way(cell1);
        assertThat(cellsArr[3].getHorizontal(), is(cells[3].getHorizontal()));
    }
}