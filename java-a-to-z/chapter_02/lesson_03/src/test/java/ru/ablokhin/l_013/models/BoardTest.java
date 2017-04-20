package ru.ablokhin.l_013.models;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Класс для проверки методов haveFiguresIn() и move()
 * @author ablokhin
 * @since 31.03.2017
 * @version 1
 */
public class BoardTest {

    //Массив фигур на доске
    Figure[] figures = new Figure[]{
            new Bishop(new Cell(1,2)),
            new Bishop(new Cell(4,2)),
            new Bishop(new Cell(2,7)),
            new Bishop(new Cell(5,2)),
            new Bishop(new Cell(4,5))
    };

    //Шахматная доска
    Board board = new Board(this.figures);

    /**
     * Метод проверки haveFiguresIn()
     */
    @Test
    public void boardHaveFiguresInCellsTest() throws OccupiedWayException {
        assertFalse(this.board.haveFiguresIn(
                new Cell[]{
                new Cell(2,3),
                new Cell(3,4),
        }, this.figures[0]));
    }

    /**
     * Метод проверки выброса исключения FigureNotFoundException
     * @throws ImpossibleMoveException исключение в случае не возможности переместить фигуру в заданную клетку
     * @throws OccupiedWayException исключение в случае, если путь в заданную клетку занят фигурами
     * @throws FigureNotFoundException исключение в случае отсутствия фигуры в source клетке
     */
    @Test
    public void figureNotFoundTest() throws FigureNotFoundException, ImpossibleMoveException, OccupiedWayException {
        assertFalse(this.board.move(new Cell(2,2), new Cell(7,8)));
    }

    /**
     * Метод проверки выброса исключения ImpossibleMoveException
     * @throws ImpossibleMoveException исключение в случае не возможности переместить фигуру в заданную клетку
     * @throws OccupiedWayException исключение в случае, если путь в заданную клетку занят фигурами
     * @throws FigureNotFoundException исключение в случае отсутствия фигуры в source клетке
     */
    @Test
    public void figureCanNotMoveTest() throws FigureNotFoundException, ImpossibleMoveException, OccupiedWayException {
        assertFalse(this.board.move(new Cell(1,2), new Cell(8,8)));
}

    /**
     * Метод проверки выброса исключения OccupiedWayException
     * @throws ImpossibleMoveException исключение в случае не возможности переместить фигуру в заданную клетку
     * @throws OccupiedWayException исключение в случае, если путь в заданную клетку занят фигурами
     * @throws FigureNotFoundException исключение в случае отсутствия фигуры в source клетке
     */
    @Test
    public void figureWayIsOccupiedTest() throws FigureNotFoundException, ImpossibleMoveException, OccupiedWayException {
        assertFalse(this.board.move(new Cell(1,2), new Cell(7,8)));
    }

    /**
     * Метод проверки move()
     * @throws ImpossibleMoveException исключение в случае не возможности переместить фигуру в заданную клетку
     * @throws OccupiedWayException исключение в случае, если путь в заданную клетку занят фигурами
     * @throws FigureNotFoundException исключение в случае отсутствия фигуры в source клетке
     */
    @Test
    public void figureIsCanMoveTest() throws FigureNotFoundException, ImpossibleMoveException, OccupiedWayException {
        assertTrue(this.board.move(new Cell(1,2), new Cell(3,4)));
    }
}