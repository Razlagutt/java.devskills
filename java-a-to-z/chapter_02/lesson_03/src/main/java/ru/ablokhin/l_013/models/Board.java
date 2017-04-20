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
    protected boolean haveFiguresIn(Cell[] cells, Figure figure) throws OccupiedWayException{
        boolean boardHaveFiguresInCells = false;
        for (Figure checkFigure : this.figures) {
            for (Cell cell : cells) {
                if ( cell != null &&
                        figure != null &&
                        checkFigure != null &&

                        //Условие, исключающее из проверки фигуру, которую нужно переместить
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
        if (boardHaveFiguresInCells){
            throw new OccupiedWayException("Figure way is occupied!");
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
    protected boolean move(Cell source, Cell dist) {
        boolean figureIsCanMove = false;
        try{
            Figure figure = source.isFilledWith(this.figures);
            Cell[] cells = figure.way(dist);
            if (!this.haveFiguresIn(cells, figure)) {
                for (int i = 0; i < figures.length; i++) {
                    if (figures[i] != null && figure.equals(figures[i])) {
                        figures[i] = figure.clone(dist);
                        figureIsCanMove = true;
                        break;
                    }
                }
            }
        }catch (FigureNotFoundException ffe){
            System.out.println("Figure not found!");
        }catch (ImpossibleMoveException ime){
            System.out.println("Figure can't move!");
        }catch (OccupiedWayException owe){
            System.out.println("Figure way is occupied!");
        }
        return figureIsCanMove;
    }
}
