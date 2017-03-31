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
        for (int i = 0; i < figures.length; i++) {

            //Проверить наличие фигуры в массиве по source координатам
            if ( figures[i].equals(source)) {
                isFound = true;

                //Проверить возможность поместить фигуру в dist ячейку
                Cell[] cells = figures[i].way(dist);
                for (Cell cell : cells) {
                    if (cell != null){
                        isMove = true;

                        //Проверить, что путь свободен
                        for (Figure figure : this.figures) {
                            if ( figure.equals(cell) ){
                                isNotOccupied = false;
                            }
                        }
                    }
                }
                if (isNotOccupied && isMove && isFound){
                    figures[i] = figures[i].clone(dist);
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
