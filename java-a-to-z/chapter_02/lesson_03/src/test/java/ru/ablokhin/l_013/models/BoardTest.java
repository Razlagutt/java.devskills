package ru.ablokhin.l_013.models;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Blokhin on 31.03.2017.
 */
public class BoardTest {
    @Test
    public void move() throws Exception {
        Cell dist = new Cell(6,6);
        Cell source = new Cell(1,1);
        Cell cellFigure = new Cell(2,3);
        Cell cellBishop = new Cell(1,1);
        Bishop figure = new Bishop(cellFigure);
        Bishop bishop = new Bishop(cellBishop);
        Figure[] figures = new Figure[2];
        figures[0] = figure;
        figures[1]= bishop;
        Board board = new Board(figures);
        boolean isMove = board.move(source, dist);
        assertTrue(isMove);
    }
}