package ru.ablokhin.l_012.start;

import ru.ablokhin.l_012.models.Order;

/**
 * Created by Blokhin on 22.08.2016.
 */
public class StartUI {
    public static void main(String[] args) {
        /* Создание заявки*/
        Tracker tracker = new Tracker();
        Order order = new Order("First Order", "Add First Order.");
        tracker.add(order);
        System.out.println("ADD ORDER:"
                + "\nName: " + tracker.showOrders()[0].getName()
                + "\nDescription: " + tracker.showOrders()[0].getDescription()
                + "\nDate: " + tracker.showOrders()[0].getDate() + "\n-----------");

        /* Редактирование заявки*/
        Order orderToEdit = tracker.editOrder("First Order");
        orderToEdit.setDescription("First Order Was Changed.");
        System.out.println("EDIT ORDER:"
                + "\nName: " + tracker.showOrders()[0].getName()
                + "\nDescription: " + tracker.showOrders()[0].getDescription()
                + "\nDate: " + tracker.showOrders()[0].getDate() + "\n-----------");

        /* Добавление комметария к заявке*/
        tracker.commentToOrder("First Order", "Great Service!");

        /* Вывод всех заявок*/
        for (Order orderToShow: tracker.showOrders()) {
            if(orderToShow != null) {
                System.out.println("SHOW ORDERS:"
                        + "\nName: " + orderToShow.getName()
                        + "\nDescription: " + orderToShow.getDescription()
                        + "\nDate: " + orderToShow.getDate() + "\n");
                String[] comments = orderToShow.getComments();
                for (String comment: comments) {
                    if(comment != null && comment.equals("") ){
                        System.out.println("Comments:");
                        System.out.println("- " + comment + "\n");
                    }
                }
            }
        }
        System.out.println("-----------");

        /* Поиск заявок по периоду*/
        Order[] findOrders = tracker.findOrder("2016.07.30 12:12:12", "2016.08.30 12:12:12");
        for(Order findOrder: findOrders){
            if(findOrder != null) {
                System.out.println("FIND ORDER BY PERIOD:"
                        + "\nName: " + findOrder.getName()
                        + "\nDescription: " + findOrder.getDescription()
                        + "\nDate: " + findOrder.getDate() + "\n-----------");
            }
        }

        /* Поиск заявок по подстроке*/
        findOrders = tracker.findOrder("First");
        for (Order findOrder: findOrders){
            if(findOrder != null) {
                System.out.println("FIND ORDER BY SUBSTRING:"
                        + "\nName: " + findOrder.getName()
                        + "\nDescription: " + findOrder.getDescription()
                        + "\nDate: " + findOrder.getDate() + "\n-----------");
            }
        }

        /* Удаление заявки*/
        if (tracker.removeOrder("First Order")){
            System.out.println("Order is remove successfully!");
        } else {
            System.out.println("Order isn't remove!");
        }
    }
}
