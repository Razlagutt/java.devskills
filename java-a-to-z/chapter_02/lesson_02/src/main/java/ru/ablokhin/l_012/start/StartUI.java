package ru.ablokhin.l_012.start;

import ru.ablokhin.l_012.models.Order;

/**
 * Created by Blokhin on 22.08.2016.
 */
public class StartUI {
    public static void main(String[] args) {

        /* Инициализация трекера*/
        Tracker tracker = new Tracker();

        /* Создание заявки*/
        System.out.println("ADD ORDER:");
        Order order1 = new Order("First Order", "Add First Order.");
        tracker.add(order1);
        order1.setId("1");

        Order order2 = new Order("Second Order", "Add Second Order.");
        tracker.add(order2);
        order2.setId("2");

        Order order3 = new Order("Third Order", "Add Third Order.");
        tracker.add(order3);
        order3.setId("3");

        Order order4 = new Order("Fourth Order", "Add Fourth Order.");
        tracker.add(order4);
        order4.setId("4");

        for (Order orderToShow: tracker.showOrders()) {
            if(orderToShow != null) {
                System.out.println(String.format("ID: %s", orderToShow.getId()));
                System.out.println(String.format("Name: %s", orderToShow.getName()));
                System.out.println(String.format("Description: %s", orderToShow.getDescription()));
                System.out.println(String.format("Date: %s", orderToShow.getDate()));
                System.out.println();
                String[] comments = orderToShow.getComments();
                for (String comment: comments) {
                    if(comment != null && !comment.equals("") ){
                        System.out.println("Comments:");
                        System.out.println("- " + comment + "\n");
                    }
                }
            }
        }
        System.out.println("-----------");

        /* Редактирование заявки*/
        Order orderToEdit = tracker.editOrder("2", "Changed Order", "Changed Description");
        System.out.println("EDIT ORDER:");
        System.out.println(String.format("ID: %s", orderToEdit.getId()));
        System.out.println(String.format("Name: %s", orderToEdit.getName()));
        System.out.println(String.format("Description: %s", orderToEdit.getDescription()));
        System.out.println(String.format("Date: %s", orderToEdit.getDate()));
        System.out.println("-----------");

        /* Добавление комметария к заявке*/
        if(tracker.commentToOrder("1", "Great Service!")){
            System.out.println("Add comment successfully!");
            System.out.println("-----------");
        }

        /* Вывод всех заявок*/
        System.out.println("SHOW ORDERS:");
        for (Order orderToShow: tracker.showOrders()) {
            if(orderToShow != null) {
                System.out.println(String.format("ID: %s", orderToShow.getId()));
                System.out.println(String.format("Name: %s", orderToShow.getName()));
                System.out.println(String.format("Description: %s", orderToShow.getDescription()));
                System.out.println(String.format("Date: %s", orderToShow.getDate()));
                System.out.println();
                String[] comments = orderToShow.getComments();
                for (String comment: comments) {
                    if(comment != null && !comment.equals("") ){
                        System.out.println("Comments:");
                        System.out.println("- " + comment);
                        System.out.println();
                    }
                }
            }
        }
        System.out.println("-----------");

        /* Поиск заявок по периоду*/
        System.out.println("FIND ORDER BY PERIOD:");
        Order[] findOrders = tracker.findOrder("2016.07.30 12:12:12", "2016.08.30 12:12:12");
        for(Order findOrder: findOrders){
            if(findOrder != null) {
                System.out.println(String.format("ID: %s", findOrder.getId()));
                System.out.println(String.format("Name: %s", findOrder.getName()));
                System.out.println(String.format("Description: %s", findOrder.getDescription()));
                System.out.println(String.format("Date: %s", findOrder.getDate()));
                System.out.println("-----------");
            }
        }

        /* Поиск заявок по подстроке*/
        findOrders = tracker.findOrder("Changed");
        System.out.println("FIND ORDER BY SUBSTRING:");
        for (Order findOrder: findOrders){
            if(findOrder != null) {
                System.out.println(String.format("ID: %s", findOrder.getId()));
                System.out.println(String.format("Name: %s", findOrder.getName()));
                System.out.println(String.format("Description: %s", findOrder.getDescription()));
                System.out.println(String.format("Date: %s", findOrder.getDate()));
                System.out.println("-----------");
            }
        }

        /* Удаление заявки*/
        tracker.removeOrder("1");
        System.out.println("REMOVE ORDER ID = 1:");
        for (Order orderToShow: tracker.showOrders()) {
            if(orderToShow != null) {
                System.out.println(String.format("ID: %s", orderToShow.getId()));
                System.out.println(String.format("Name: %s", orderToShow.getName()));
                System.out.println(String.format("Description: %s", orderToShow.getDescription()));
                System.out.println(String.format("Date: %s", orderToShow.getDate()));
                System.out.println();
                String[] comments = orderToShow.getComments();
                for (String comment: comments) {
                    if(comment != null && comment.equals("") ){
                        System.out.println("Comments:");
                        System.out.println("- " + comment);
                    }
                }
            }
        }
        System.out.println("-----------");
    }
}
