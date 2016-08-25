package ru.ablokhin.l_012.start;

import ru.ablokhin.l_012.models.Order;

/**
 * Class Init инициализирует работу с заявками
 * @author ablokhin
 * @since 24.08.2016
 * @version 3
 */
public class InitTest {

    private String choice, param1, param2, param3;
	private Input input;
	
	public InitTest(Input input){
		this.input = input;
	}

	void init(){
		/* Инициализация трекера*/
        Tracker tracker = new Tracker();

        /* Инициализация ввода*/
        //ConsoleInput input = new ConsoleInput();

        /* Инициализация меню*/
        Menu menu = new Menu();

        /* Приветствие*/
        System.out.println(menu.getGreeting());

        /* Описание программы*/
        System.out.println(menu.getDescription());

        do {
            /* Вывод меню*/
            System.out.println();
            System.out.println("--------| MENU |--------");
            for (String choice : menu.getChoices()) {
                System.out.println(choice);
            }
            System.out.println("------------------------");
            //System.out.println();

            /* Выбор пользователя*/
            this.choice = input.ask("Enter The Number 0-7 To Select The Menu Item, Please: ");

            /* ADD ORDER*/
            if( this.choice.equals("1") ){
                this.param1 = input.ask("Enter The Order Name, Please: ");
                this.param2 = input.ask("Enter The Order Description, Please: ");
                Order order = new Order(this.param1, this.param2);
                tracker.add(order);
                System.out.println("\nYour Order Is Added Successfully!");
            }

            /* EDIT ORDER*/
            if( this.choice.equals("2") ){
                this.param1 = tracker.showOrders()[0].getId(); //input.ask("Enter The Order ID For Edit, Please: ");
                this.param2 = input.ask("Enter The New Order Name, Please: ");
                this.param3 = input.ask("Enter The New Order Description, Please: ");
                if(tracker.editOrder(this.param1, this.param2, this.param3)){
                    System.out.println("\nYour Order Is Edited Successfully!");
                } else {
                    System.out.println("\nOrder Not Found For Edit! Order ID is Wrong!");
                }
            }

            /* REMOVE ORDER*/
            if( this.choice.equals("3") ){
                this.param1 = tracker.showOrders()[0].getId(); //input.ask("Enter The Order ID For Remove, Please: ");
                if(tracker.removeOrder(this.param1)){
                    System.out.println("\nYour Order Is Removed Successfully!");
                } else {
                    System.out.println("\nOrder Not Found For Remove! Order ID is Wrong!");
                }
            }

            /* FIND ORDER FOR THE PERIOD*/
            if( this.choice.equals("4") ){
                this.param1 = input.ask("Enter The Start Date For Search, Please: ");
                this.param2 = input.ask("Enter The Finnish Date For Search, Please: ");
                Order[] findOrders = tracker.findOrder(this.param1, this.param2);
                System.out.println("\nFound Orders For The Period:");
                System.out.println("------------------------");
                for(Order findOrder: findOrders){
                    if(findOrder != null) {
                        System.out.println(String.format("ID: %s", findOrder.getId()));
                        System.out.println(String.format("Name: %s", findOrder.getName()));
                        System.out.println(String.format("Description: %s", findOrder.getDescription()));
                        System.out.println(String.format("Date: %s", findOrder.getDate()));
                    }
                }
            }

            /* FIND ORDER BY SUBSTRING*/
            if( this.choice.equals("5") ){
                this.param1 = input.ask("Enter The Substring For Search, Please: ");
                Order[] findOrders = tracker.findOrder(this.param1);
                System.out.println("\nFound Orders Using Substring:");
                System.out.println("------------------------");
                for(Order findOrder: findOrders){
                    if(findOrder != null) {
                        System.out.println(String.format("ID: %s", findOrder.getId()));
                        System.out.println(String.format("Name: %s", findOrder.getName()));
                        System.out.println(String.format("Description: %s", findOrder.getDescription()));
                        System.out.println(String.format("Date: %s", findOrder.getDate()));
                    }
                }
            }

            /* SHOW ORDERS*/
            if( this.choice.equals("6") ){
                for (Order orderToShow: tracker.showOrders()) {
                    if(orderToShow != null) {
                        System.out.println("\nOrder List:");
                        System.out.println("------------------------");
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
                            }
                        }
                    }
                }
            }

            /* ADD COMMENT TO ORDER*/
            if( this.choice.equals("7") ){
                this.param1 = tracker.showOrders()[0].getId(); //input.ask("Enter The Order ID For Search The Order To Add The Comment, Please: ");
                this.param2 = input.ask("Enter The Comment To The Order, Please: ");
                if(tracker.commentToOrder(this.param1, this.param2)){
                    System.out.println("\nYour Comment Is Added To The Order Successfully!");
                } else {
                    System.out.println("\nOrder Not Found For Comment! Order ID is Wrong!");
                }
            }
        }while( !this.choice.equals("0") );

        System.out.println("\nThe Application Is Over!");
        System.out.println("Good Bye!");
	}
}
