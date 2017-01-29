package ru.ablokhin.l_012.start;

import ru.ablokhin.l_012.models.Order;

import java.util.Random;
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

	private static final Random RN = new Random();

	/**
	 * Метод add для создания заявки
	 * @param order заявка
	 * @return true, если успешно добавлено
	 */
	public Order add(Order order){
		order.addDate();
		order.setId(generate());
		this.orders[indx++] = order;
		return this.orders[indx];
	}

	/**
	 * Метод editOrder ищет заявку для редактирования
	 * @param id идентификатор заявки
	 * @return возвращает найденную заявку
	 */
	public boolean editOrder(String id, String name, String description){
		boolean result = false;
		for (Order order : this.orders) {
			if ( order != null && order.getId().equals(id)) {
				order.setName(name);
				order.setDescription(description);
				order.addDate();
				result = true;
				break;
			}
		}
		return result;
	}

	/**
	 * Метод removeOrder удаляет заявку
	 * @param id идентификатор заявки
	 * @return true, если заявка успешно удалена
	 */
	public boolean removeOrder(String id){
		boolean result = false;
        for ( int i = 0; i != this.indx + 1; i++){
            if ( this.orders[i] != null && this.orders[i].getId().equals(id)) {
				this.orders[i] = null;
				result = true;
				break;
            }
        }

        for(int i = 0; i < this.orders.length - 1; i++){
        	if(this.orders[i] == null && this.orders[i+1] != null){
        		Order tmp = this.orders[i];
				this.orders[i] = this.orders[i+1];
				this.orders[i+1] = tmp;
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
	    Order[] orderToShow = new Order[999];
		for(int i = 0; i != this.indx + 1; i++){
			orderToShow[indxShow++] = this.orders[i];
        }
	    return orderToShow;
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
	 * @param order заявка
	 * @param comment комментарий к заявке
	 */
	public void commentToOrder(Order order, String comment){

		order.getComments()[commentIndx++] = comment;
	}

	/**
	 * Метод commentToOrder для добавления комментария к заявке
	 * @param id заявки
	 */
	public Order[] findById(String id){
		Order[] result = new Order[1];
		for (Order order : this.orders){
			if (order != null && order.getId().equals(id)){
				result[0] = order;
				break;
			}
		}
		return result;
	}

	String generate(){
		return String.valueOf(System.currentTimeMillis() + RN.nextInt());
	}

}