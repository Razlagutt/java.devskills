package ru.ablokhin.l_013.models;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Blokhin on 31.03.2017.
 */
public class BoardTest {
    @Test
    public void move() throws Exception {
        Figure figure = new Bishop(new Cell(3,6));
        Figure bishop = new Bishop(new Cell(1,1));
        Figure[] figures = new Figure[2];
        figures[0] = figure;
        figures[1]= bishop;
        Board board = new Board(figures);
        boolean isMove = board.move(new Cell(1,1), new Cell(4,4));
        assertTrue(isMove);
    }
}