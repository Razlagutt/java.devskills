package ru.ablokhin.l_013.models;

/**
 * Класс для определения шахматной доски
 * @author ablokhin
 * @since 31.03.2017
 * @version 1
 */
public class Board {

    //Массив фигур на доске
    protected Figure[] figures;

    /**
     * Конструктор шахматной доски
     * @param figures фигуры, помещаемые на доску
     */
    public Board(Figure[] figures){
        this.figures = figures;
    }

    /**
     * Метод проверяет не занят ли путь фигурами
     * @param cells путь фигуры до заданной клетки
     * @param figure фигура, которую нужно переместить на заданную клетку
     * @return возвращает true, если путь свободен
     * @throws OccupiedWayException исключение в случае наличие фигур(ы) на пути следования
     */
    protected boolean haveFiguresIn(Cell[] cells, Figure figure){
        boolean boardHaveFiguresInCells = false;
        for (Figure checkFigure : this.figures) {
            for (Cell cell : cells) {
                if ( cell != null &&
                        figure != null &&
                        checkFigure != null &&

                        //Условие, исключающее из проверки фигуру, которую нужно переметить
                        !(checkFigure.position.getHorizontal() == figure.position.getHorizontal() &&
                        checkFigure.position.getVertical() == figure.position.getVertical()) &&

                        //Условие, проверяющее занятость клетки фигурой
                        checkFigure.position.getHorizontal() == cell.getHorizontal() &&
                        checkFigure.position.getVertical() == cell.getVertical()){
                    boardHaveFiguresInCells = true;
                    break;
                }
            }
        }
        return boardHaveFiguresInCells;
    }

    /**
     * Метод проверяет наличие возможноти переместить фигуру в заданную клетку
     * @param source текущее положение фигуры
     * @param dist заданная клетка для перемещения туда фигуры
     * @return возвращает true, если есть возможность переместить фигуру в заданную клетку
     * @throws ImpossibleMoveException исключение в случае не возможности переместить фигуру в заданную клетку
     * @throws OccupiedWayException исключение в случае, если путь в заданную клетку занят фигурами
     * @throws FigureNotFoundException исключение в случае отсутствия фигуры в source клетке
     */
    protected boolean move(Cell source, Cell dist) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException{
        boolean figureIsCanMove = false;
        Figure figure = source.isFilledWith(this.figures);
        if (figure == null){throw new FigureNotFoundException("Figure not found!");}
        else if (figure.way(dist)[0] == null){throw new ImpossibleMoveException("Figure can't move!");}
        else if (this.haveFiguresIn(figure.way(dist), figure)){throw new OccupiedWayException("Figure way is occupied");}
        else {
            figure.clone(dist);
            figureIsCanMove = true;
        }
        return figureIsCanMove;
    }
}
