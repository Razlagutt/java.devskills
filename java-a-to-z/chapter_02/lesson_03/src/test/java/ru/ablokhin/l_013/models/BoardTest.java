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
            new Bishop(new Cell(8,4))
    };

    //Путь перемещения фигуры
    Cell[] cells = new Cell[]{
            new Cell(2,3),
            new Cell(3,4),
            new Cell(4,5),
            new Cell(5,6)
    };

    /**
     * Метод проверки haveFiguresIn()
     */
    @Test
    public void haveFiguresIn(){
        Board board = new Board(this.figures);
        boolean boardHaveFiguresInCells = board.haveFiguresIn(this.cells, this.figures[0]);
        assertFalse(boardHaveFiguresInCells);
    }

    /**
     * Метод проверки move()
     * @throws ImpossibleMoveException исключение в случае не возможности переместить фигуру в заданную клетку
     * @throws OccupiedWayException исключение в случае, если путь в заданную клетку занят фигурами
     * @throws FigureNotFoundException исключение в случае отсутствия фигуры в source клетке
     */
    @Test
    public void move() throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        Board board = new Board(this.figures);
        boolean figureIsCanMove = board.move(new Cell(1,2), this.cells[3]);
        assertTrue(figureIsCanMove);
    }
}