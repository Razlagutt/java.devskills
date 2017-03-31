package ru.ablokhin.l_013.models;

/**
 * Created by Blokhin on 30.03.2017.
 */
public class Board {
    public Figure[] figures;

    public Board(Figure[] figures){
        this.figures = figures;
    }

    boolean move(Cell source, Cell dist) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException{
        boolean isNotOccupied = true;
        boolean isMove = false;
        boolean isFound = false;
        for (int i = 0; i < this.figures.length; i++) {

            //Проверить наличие фигуры в массиве по source координатам
            if ( (this.figures[i].position.getHorisontal() == source.getHorisontal())
                    && (this.figures[i].position.getVertical() == source.getVertical()) ) {
                isFound = true;

                //Проверить возможность поместить фигуру в dist ячейку
                Cell[] cells = this.figures[i].way(dist);
                //for (int j = 1; j < cells.length; j++) {
                for (Cell cell : cells){
                    if (cell != null){
                        isMove = true;

                        //Проверить, что путь свободен
                        for (Figure figure1 : this.figures) {
                            if ( (figure1.position.getHorisontal() == cell.getHorisontal())
                                    && (figure1.position.getVertical() == cell.getVertical()) ){
                                isNotOccupied = false;
                            }
                        }
                    }
                }
                if (isNotOccupied && isMove && isFound){
                    this.figures[i] = this.figures[i].clone(dist);
                    break;
                }
            }
        }
        if (!isFound){
            throw new FigureNotFoundException("Figure not found!");
        }
        if (!isNotOccupied){
            throw new OccupiedWayException("Figure way is occupied");
        }
        return isNotOccupied && isMove && isFound;
    }
}
