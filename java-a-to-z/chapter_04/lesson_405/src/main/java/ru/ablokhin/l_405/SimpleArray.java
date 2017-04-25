package ru.ablokhin.l_405;

/**
 * Обощенный класс, описывающий контейнер данных
 * @author Blokhin
 * @since  25.04.2017
 * @version 1
 */
public class SimpleArray<T> {

    //Обощенный массив
    private T[] arr;
    //Индекс массива
    private int index;

    /**
     * Конструктор контейнера данных
     * @param arr массив данных
     */
    public SimpleArray(T[] arr){
        this.arr = arr;
    }

    /**
     * Метод добавляет объект в контейнер
     * @param obj объект для добавления в контейнер
     */
    protected void add(T obj){
        this.arr[this.index++] = obj;
    }

    /**
     * Метод, изменяющий объект в контейнере по индексу
     * @param obj объект, которым нужно заменить объект в контецнере
     * @param index индекс объекта в контейнере, подлежащий изменению на obj
     */
    protected void update(T obj, int index){
        this.arr[index] = obj;
    }

    /**
     * Метод удаления объекта из контейнера
     * @param obj объект, который нужно удалить из контейнера
     */
    protected void delete(T obj){
        for ( int i = 0; i < this.arr.length; i++){
            if ( this.arr[i] != null && this.arr[i].equals(obj)) {
                this.arr[i] = null;
                break;
            }
        }

        for(int i = 0; i < this.arr.length - 1; i++){
            if(this.arr[i] == null && this.arr[i+1] != null){
                T tmp = this.arr[i];
                this.arr[i] = this.arr[i+1];
                this.arr[i+1] = tmp;
            }
        }
    }

    /**
     * Метод получения объекта по индексу
     * @param index объекта в контейнере
     * @return возращает объект по индексу
     */
    protected T get(int index){
        return this.arr[index];
    }
}
