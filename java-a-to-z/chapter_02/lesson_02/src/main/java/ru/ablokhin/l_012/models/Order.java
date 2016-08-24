package ru.ablokhin.l_012.models;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

/**
 * Class Order описания структуры заявки
 * @author ablokhin
 * @since 21.08.2016
 * @version 1
 */
public class Order{

	/* Идентификационный номер заявки*/
	private String id;
    /* Имя заявки    */
	private String name;
    /* Описание заявки    */
	private String description;
    /* Дата создания заявки    */
	private LocalDateTime date;
    /* Комментарии к заявке    */
	private String[] comments = new String[999];

    /**
     * Конструктор класса Order
     * @param name имя заявки
     * @param description описание заявки
     */
	public Order(String name, String description){
		
		this.name = name;
		this.description = description;
	}

    /**
     * Метод получения имени заявки
     * @return возвращает имя заявки
     */
	public String getName(){return this.name;}

    /**
     * Метод, устанавливающий новое имя заявки
     * @param name передает новое имя заявки
     */
	public void setName(String name){this.name = name;}

    /**
     * Метод получения описания заявки
     * @return содержание заявки
     */
	public String getDescription(){return this.description;}

    /**
     * Метод позволяет задать новое описание заявки
     * @param description текст описания
     */
	public void setDescription(String description){this.description = description;}

    /**
     * Метод получения даты создания заявки
     * @return дата создания заявки
     */
	public LocalDateTime getDate(){return this.date;}

    /**
     * Метод устанавливающий дату создания заявки
     */
	public void setDate(){
	    this.date = LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss")),
                DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
	}

    /**
     * Метод для обнуления даты создания заявки. Используется при удалении заявки из базы
     * @param date = null
     */
    public void setDate(LocalDateTime date){this.date = date;}

    /**
     * Метод возвращающий массив комментариев к заявке
     * @return массив комментариев
     */
	public String[] getComments(){return this.comments;}

	public String getId(){ return this.id;}

	public void setId(String id){ this.id = id; }
}