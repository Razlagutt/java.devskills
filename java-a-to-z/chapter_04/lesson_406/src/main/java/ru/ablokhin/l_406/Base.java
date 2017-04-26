package ru.ablokhin.l_406;

/**
 * Created by Blokhin on 26.04.2017.
 */
public abstract class Base {

    String id;

    public Base(String id){
        this.id = id;
    }

    public abstract String getId();

    public abstract void setId(String id);
}
