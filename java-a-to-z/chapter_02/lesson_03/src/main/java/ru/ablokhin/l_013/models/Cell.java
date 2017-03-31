package ru.ablokhin.l_013.models;

/**
 * Created by Blokhin on 30.03.2017.
 */
public class Cell {
    private int vertical;
    private int horisontal;

    public Cell(int vertical, int horisontal){
        this.vertical = vertical;
        this.horisontal = horisontal;
    }

    public int getHorisontal() {
        return horisontal;
    }

    public int getVertical() {
        return vertical;
    }
}
