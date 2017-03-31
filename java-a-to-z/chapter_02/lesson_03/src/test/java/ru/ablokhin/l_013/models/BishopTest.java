package ru.ablokhin.l_013.models;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Blokhin on 31.03.2017.
 */
public class BishopTest {
    @Test
    public void way() throws Exception {
        Cell[] cellsArr = new Cell[8];
        cellsArr[0] = new Cell(1,1);
        cellsArr[1] = new Cell(2,2);
        cellsArr[2] = new Cell(3,3);
        cellsArr[3] = new Cell(4,4);
        cellsArr[4] = new Cell(5,5);
        /*cellsArr[5] = new Cell(6,6);
        cellsArr[6] = new Cell(7,7);
        cellsArr[7] = new Cell(8,8);*/
        Cell cell = new Cell(1,1);
        Cell cell1 = new Cell(5,5);
        Bishop bishop = new Bishop(cell);
        Cell[] cells = bishop.way(cell1);
        assertThat(cellsArr[4].getHorisontal(), is(cells[4].getHorisontal()));
    }

}