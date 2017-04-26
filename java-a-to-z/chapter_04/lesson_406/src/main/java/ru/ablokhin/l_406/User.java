package ru.ablokhin.l_406;

/**
 * Created by Blokhin on 26.04.2017.
 */
public class User extends Base {

    String id;

    public User(String id){
        super(id);
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
}
