package ru.ablokhin.l_013.models;

/**
 * Created by Blokhin on 30.03.2017.
 */
public class Cell {
    private int[] position = new int[8];

    public Cell(int[] position){
        this.position = position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public int[] getPosition() {
        return position;
    }
}
