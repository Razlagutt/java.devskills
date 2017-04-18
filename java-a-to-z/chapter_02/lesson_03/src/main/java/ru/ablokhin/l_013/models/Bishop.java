package ru.ablokhin.l_013.models;

/**
 * Класс для определения шахматной фигуры Слон
 * @author ablokhin
 * @since 31.03.2017
 * @version 1
 */
public class Bishop extends Figure {

    /**
     * Конструктор фигуры Слон
     * @param position изначальная позиция фигуры Слон на щахматной доске
     */
    public Bishop(Cell position) {
        super(position);
    }

    /**
     * Метод проверяет возможность переместить фигуру Слон в заданную клетку
     * @param dist клетка, куда надо переместить фигуру Слон
     * @return cells массив клеток, по которым будет перемещаться фигура Слон
     * @throws ImpossibleMoveException исключение в случае не возможности переместить фигуру Слон в заданную клетку
     */
    protected Cell[] way(Cell dist) throws ImpossibleMoveException {

        //Инициализация массива клеток
        Cell[] cells = new Cell[8];

        //Получить координаты фигуры
        int verticalPosition = this.position.getVertical();
        int horizontalPosition = this.position.getHorizontal();

        //Получить заданные координаты фигуры
        int specifiedVerticalPosition = dist.getVertical();
        int specifiedHorizontalPosition = dist.getHorizontal();

        //Получить расстояние между текущим и заданным положением фигуры
        int distance = Math.abs(verticalPosition - specifiedVerticalPosition);

        //Получить координаты клетки, куда может переместиться фигура при заданном расстоянии
        int possibleVerticalPosition = verticalPosition + distance;
        int possibleHorizontalPosition = horizontalPosition + distance;

        //Сравнить заданные координаты движения фигуры с возможным ее движением при заданном расстоянии
        if ( (possibleVerticalPosition == specifiedVerticalPosition)
                && (possibleHorizontalPosition == specifiedHorizontalPosition)
                && (this.position.getVertical() != dist.getVertical())
                && (this.position.getHorizontal() != dist.getHorizontal()) ){

            //Создать массив движения фигуры
            for (int i = 0; i < distance; i++){
                cells[i] = new Cell(verticalPosition + i + 1, horizontalPosition + i + 1);
            }
            return cells;
        } else {
            throw new ImpossibleMoveException("Impossible move!");
        }
    }

    /**
     * Метод перемещает фигуру Слон в заданную клетку
     * @param cell заданная клетка для перемещения
     * @return возвращает фигуру Слон с новым местоположением на доске
     */
    protected Figure clone(Cell cell){
        return new Bishop(cell);
    }
}
