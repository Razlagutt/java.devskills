package ru.ablokhin.l_012.start;

import ru.ablokhin.l_012.models.Order;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

/**
 * Class Tracker для работы с заявками
 * @author ablokhin
 * @since 21.08.2016
 * @version 1
 */
public class Tracker{

	/** Массив заявок */
	private Order[] orders = new Order[999];
	/** Индекс массива заявок при добавлении заявки в базу данных */
	private int indx = 0;
	/** Индекс массива заявок при добавлении комментария к заявке в базу данных */
	private int commentIndx = 0;

	/**
	 * Метод add для создания заявки
	 * @param order заявка
	 * @return true, если успешно добавлено
	 */
	public boolean add(Order order){
		this.orders[indx++] = order;
		return true;
	}

	/**
	 * Метод editOrder ищет заявку для редактирования
	 * @param name имя заявки
	 * @return возвращает найденную заявку
	 */
	public Order editOrder(String name){
		Order result = null;
        for (Order order : this.orders) {
            if (order.getName().equals(name)) {
                result = order;
                break;
            }
        }
		return result;
	}

	/**
	 * Метод removeOrder удаляет заявку
	 * @param name имя заявки
	 * @return true, если заявка успешно удалена
	 */
	public boolean removeOrder(String name){
		boolean result = false;
        for (Order order : this.orders) {
            if ( order != null && order.getName().equals(name)) {
                order.setName(null);
                order.setDescription(null);
                order.setDate(null);
                String[] comments = order.getComments();
                comments = null;
                /*for (String comment : order.getComments()) {
                    comment = null;
                }*/
                result = true;
            }
        }
		return result;
	}

	/**
	 * Метод showOrders показывает все заявки
	 * @return массив заявок
	 */
	public Order[] showOrders(){
	    int indxShow = 0;
	    Order[] orderToSshow = new Order[999];
        for(Order order: this.orders){
            if(order != null) {orderToSshow[indxShow++] = order;}
        }
	    return orderToSshow;
	}

	/**
	* Метод findOrder ищет заявки за период с dateFrom по dateTo
	* @param dateFrom дата начала поиска
	* @param dateTo дата окончания поиска
	* @return массив найденных заявок
	*/
	public Order[] findOrder(String dateFrom, String dateTo){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
		LocalDateTime parseDateFrom = LocalDateTime.parse(dateFrom, formatter);
		LocalDateTime parseDateTo = LocalDateTime.parse(dateTo, formatter);
		
		Order[] result = new Order[999];
		for(int i = 0; i < this.orders.length; i++){
			if( this.orders[i] != null && (parseDateFrom.compareTo(this.orders[i].getDate()) < 0)
					&& (this.orders[i].getDate().compareTo(parseDateTo) < 0) ){
				result[i] = this.orders[i];
			}
		}
		return result;
	}

	/**
	 * Метод findOrder по подстроке. Используется когда точное имя заявки неизвестно
	 * @param substring подстрока поиска
	 * @return массив найденных заявок
	 */
	public Order[] findOrder(String substring){
		Order[] result = new Order[999];
		String[] subStr = substring.split("");		
		int resultIndx = 0;
		
		for(Order order: this.orders){
		    if(order != null) {
                int subIndx = 0;
                String[] orderName = order.getName().split("");
                if (subStr.length <= orderName.length && subStr.length > 0) {
                    for (String orName : orderName) {
                        if (subStr[subIndx].equals(orName)) {
                            subIndx++;
                        } else {
                            subIndx = 0;
                            if (subStr[subIndx].equals(orName)) subIndx++;
                        }
                        if (subIndx == subStr.length) {
                            result[resultIndx++] = order;
                            break;
                        }
                    }
                }
            }
		}
		return result;
	}

	/**
	 * Метод commentToOrder для добавления комментария к заявке
	 * @param name имя заявки
	 * @param comment комментарий к заявке
	 * @return true, если комментарий успешно добавлен
	 */
	public boolean commentToOrder(String name, String comment){
		boolean result = false;
		if( !comment.equals("") ) {
			for (Order order : this.orders) {
				if (order.getName().equals(name)) {
					order.getComments()[commentIndx++] = comment;
					result = true;
					break;
				}
			}
		}
		return result;
	}
}