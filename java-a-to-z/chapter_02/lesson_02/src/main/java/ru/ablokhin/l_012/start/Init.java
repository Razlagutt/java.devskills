package ru.ablokhin.l_012.start;

/**
 * Class Init инициализирует работу с заявками
 * @author ablokhin
 * @since 24.08.2016
 * @version 3
 */
public class Init {

    /* инициализация ключа действия пользователя*/
    private int key;

    /**
     * Метод init() инициализирует работу с заявками
     */
    void init(){

        /* Инициализация трекера*/
        Tracker tracker = new Tracker();

        /* Инициализация ввода*/
        ConsoleInput consoleInput = new ConsoleInput();

        /* Инициализация меню*/
        Menu menu = new Menu(consoleInput, tracker);

        /* Приветствие*/
        System.out.println(menu.getGreeting());

        /* Описание программы*/
        System.out.println(menu.getDescription());

        /* Заполнение меню массивом действий пользователя*/
        menu.fillActions();

        do {
            /* Вывод меню*/
            menu.show();

            /* Выбор пользователя*/
<<<<<<< Updated upstream
            this.choice = consoleInput.ask("Enter The Number 0-7 To Select The Menu Item, Please: ");

            /* ADD ORDER*/
            if( this.choice.equals("1") ){
                this.param1 = consoleInput.ask("Enter The Order Name, Please: ");
                this.param2 = consoleInput.ask("Enter The Order Description, Please: ");
                Order order = new Order(this.param1, this.param2);
                tracker.add(order);
                System.out.println("\nYour Order Is Added Successfully!");
            }

            /* EDIT ORDER*/
            if( this.choice.equals("2") ){
                this.param1 = consoleInput.ask("Enter The Order ID For Edit, Please: ");
                this.param2 = consoleInput.ask("Enter The New Order Name, Please: ");
                this.param3 = consoleInput.ask("Enter The New Order Description, Please: ");
                Order newOrder = new Order(this.param2, this.param3);
                newOrder.setId(this.param1);
                if(tracker.editOrder(newOrder)){
                    System.out.println("\nYour Order Is Edited Successfully!");
                } else {
                    System.out.println("\nOrder Not Found For Edit! Order ID is Wrong!");
                }
            }

            /* REMOVE ORDER*/
            if( this.choice.equals("3") ){
                this.param1 = consoleInput.ask("Enter The Order ID For Remove, Please: ");
                if(tracker.removeOrder(this.param1)){
                    System.out.println("\nYour Order Is Removed Successfully!");
                } else {
                    System.out.println("\nOrder Not Found For Remove! Order ID is Wrong!");
                }
            }

            /* FIND ORDER FOR THE PERIOD*/
            if( this.choice.equals("4") ){
                this.param1 = consoleInput.ask("Enter The Start Date For Search, Please: ");
                this.param2 = consoleInput.ask("Enter The Finnish Date For Search, Please: ");
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
                this.param1 = consoleInput.ask("Enter The Substring For Search, Please: ");
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
=======
            key = Integer.valueOf(consoleInput.ask("Enter The Number 0-7 To Select The Menu Item, Please: "));
>>>>>>> Stashed changes

            /* Осуществление действия по выбору пользователя*/
            menu.select(key);

        }while( key != 0 );

    }
}
