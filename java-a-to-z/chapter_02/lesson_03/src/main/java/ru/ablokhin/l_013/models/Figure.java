package ru.ablokhin.l_013.models;


public abstract class Figure{

    /*
     * Pawn = Пешка
     * Rook = Ладья
     * Knight = Конь
     * Bishop = Слон
     * Queen = Ферзь
     * King = Король
     */

    final Cell position;

    public Figure(Cell position){
        this.position = position;
    }

    abstract Cell[] way(Cell dist) throws ImpossibleMoveException;

    abstract Figure clone(Cell cell);
}