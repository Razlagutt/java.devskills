package ru.ablokhin.l_013.models;

import java.math.*;

/**
 * Created by Blokhin on 30.03.2017.
 */
public class Bishop extends Figure {
    public Bishop(Cell position) {
        super(position);
    }

    public Cell[] way(Cell dist) throws ImpossibleMoveException {

        Cell[] cells = new Cell[8];
        //Получить текущую позицию фигуры
        int posOfFigureVert = this.position.getVertical();
        int posOfFigureHor = this.position.getHorisontal();

        //Получить требуемую позицию фигуры
        int possimblePosOfFigureVert = dist.getVertical();
        int possimblePosOfFigureHor = dist.getHorisontal();

        //Получить расстояние между текущей и требуемой позициями фигуры по вертикали
        int distanceVert = Math.abs(posOfFigureVert - possimblePosOfFigureVert);

        //Получить возможную позицию фигуры при заданном расстоянии до требуемой позиции фигуры по вертикали
        int finalPosOfFigureVert = posOfFigureVert + distanceVert;
        int finalPosOfFigureHor = posOfFigureHor + distanceVert;

        //Сравнить совпадают ли возможная позиция фигуры с требуемой
        if ( (finalPosOfFigureVert == possimblePosOfFigureVert)
                && (finalPosOfFigureHor == possimblePosOfFigureHor)
                && (this.position.getVertical() != dist.getVertical())
                && (this.position.getHorisontal() != dist.getHorisontal()) ){
            //Создать массив движения фигуры
            for (int i = 0; i < distanceVert; i++){
                cells[i] = new Cell(posOfFigureVert + i + 1, posOfFigureHor + i + 1);
            }
            return cells;
        } else {
            throw new ImpossibleMoveException("Impossible move!");
        }
    }

    public Figure clone(Cell cell){
        return new Bishop(cell);
    }
}
