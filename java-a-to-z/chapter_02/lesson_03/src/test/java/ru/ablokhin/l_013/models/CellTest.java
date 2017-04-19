package ru.ablokhin.l_013.models;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Класс для проверки метода isNotFilledWith()
 * @author ablokhin
 * @since 31.03.2017
 * @version 1
 */
public class CellTest {
    /**
     * Метод для проверки метода isNotFilledWith()
     * @throws FigureNotFoundException исключение в случае, если клетка не занята фигурой
     */
    @Test
    public void isFilledWith() throws FigureNotFoundException {
        Cell cell = new Cell(1,1);
        Figure[] figures = new Figure[]{
                new Bishop(new Cell(1,3)),
                new Bishop(new Cell(1,8)),
                new Bishop(new Cell(1,8)),
                new Bishop(new Cell(1,1)),
                new Bishop(new Cell(5,8))
        };
        Figure checkFigure = cell.isFilledWith(figures);
        assertThat(new Bishop(cell).position.getHorizontal(), is(checkFigure.position.getHorizontal()));
    }
}