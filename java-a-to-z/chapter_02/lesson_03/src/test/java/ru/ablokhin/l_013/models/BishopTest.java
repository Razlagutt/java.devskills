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
        cellsArr[0] = new Cell(2,2);
        cellsArr[1] = new Cell(3,3);
        cellsArr[2] = new Cell(4,4);
        cellsArr[3] = new Cell(5,5);

        Cell cell = new Cell(1,1);
        Cell cell1 = new Cell(5,5);
        Bishop bishop = new Bishop(cell);
        Cell[] cells = bishop.way(cell1);
        assertThat(cellsArr[3].getHorisontal(), is(cells[3].getHorisontal()));
    }

}