package ru.ablokhin.l_012.start;

import ru.ablokhin.l_012.models.Order;

/**
 * Class Menu для работы с меню трекера
 * @author ablokhin
 * @since 15.01.2017
 * @version 1
 */
public class Menu{

    /*Приветсвие пользовател*/
	private static final String GREETING = "Hello, User!";
    /*Описание программы*/
	private static final String DESCRIPTION = "This Is Order Registration Application.";
    /*Инициализация ввода*/
    private Input input;
    /*Инициализация трекера*/
    private Tracker tracker;
    /*Инициализация массива пользовательских действий*/
    private UserAction[] actions = new UserAction[9];

    private int indx = 0;

    /**
     * Констуктор Menu
     * @param input пользовательский ввод
     * @param tracker трекер заявок
     */
    public Menu(Input input, Tracker tracker){
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод getGreeting вывод приветствия
     * @return возвращает приветствие пользователя
     */
	public String getGreeting(){
		return this.GREETING;
	}

	/**
     * Метод getDescription вывод описания программы
     * @return возвращает описание программы
     */
	public String getDescription(){
		return this.DESCRIPTION;
	}

	/**
     * Метод select выбор действия пользователя
     * @param key ключ децсвия пользователя
     */
	public void select(int key){
	    this.actions[key].execute(this.input, this.tracker);
    }

    /**
     * Метод fillActions заполняет массив пользовательских действий
     * @return возвращает массив возможных действий (меню)
     */
	public UserAction[] fillActions(){
	    this.actions[indx++] = new ExitFromApp("Exit");
	    this.actions[indx++] = new AddOrder("Add Order");
        this.actions[indx++] = new EditOrder("Edit Order");
        this.actions[indx++] = new RemoveOrder("Remove Order");
        this.actions[indx++] = new FindOrderForThePeriod("Find Order For The Period (yyyy.mm.dd HH:mm:ss)");
        this.actions[indx++] = new FindOrderByString("Find Order By String");
        this.actions[indx++] = new ShowOrders("Show Order List");
        this.actions[indx++] = new AddComment("Add The Comment To Order");

        return this.actions;
    }

    protected void addAction(UserAction action){
	    this.actions[indx++] = action;
    }

    /**
     * Метод show выводит меню на экран
     */
    public void show(){

        System.out.println();
        System.out.println("--------| MENU |--------");
        for (UserAction action : this.actions){
            if (action != null){
                System.out.println(action.info());
            }
        }
        System.out.println("------------------------");
        System.out.println();
    }


    /**
     * Class ExitFromApp описывает действие выхода из программы
     * @author ablokhin
     * @since 15.01.2017
     * @version 1
     */
    private class ExitFromApp extends BaseAction{

        public ExitFromApp(String name){
            super(name);
        }

        /**
         * Метод key возвращает ключ действия пользователя
         * return возвращает 0 - ключ действия выхода из программы
         */
        public int key() {
            return 0;
        }

        /**
         * Метод execute осуществляет действие выхода пользователя из программы
         * @param input ввод пользователя
         * @param tracker трекер с заявками
         */
        public void execute(Input input, Tracker tracker) {
            System.out.println("\nThe Application Is Over!");
            System.out.println("Good Bye!");
        }
    }


    /**
     * Class AddOrder описывает действие создания заявки
     * @author ablokhin
     * @since 15.01.2017
     * @version 1
     */
    private class AddOrder extends BaseAction{

        public AddOrder(String name){
            super(name);
        }

        /**
         * Метод key возвращает ключ действия пользователя
         * return возвращает 1 - ключ действия создания заявки
         */
        public int key() {
            return 1;
        }

        /**
         * Метод execute осуществляет действие создания заявки
         * @param input ввод пользователя
         * @param tracker трекер с заявками
         */
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Enter The Order Name, Please: ");
            String desc = input.ask("Enter The Order Description, Please: ");
            tracker.add(new Order(name, desc));
            System.out.println("\nYour Order Is Added Successfully!");
        }
    }

    /**
     * Class EditOrder описывает действие редактирования заявки
     * @author ablokhin
     * @since 15.01.2017
     * @version 1
     */
    class EditOrder extends BaseAction{

        public EditOrder(String name){
            super(name);
        }

        /**
         * Метод key возвращает ключ действия пользователя
         * return возвращает 2 - ключ действия редактирования заявки
         */
        public int key() {
            return 2;
        }

        /**
         * Метод execute осуществляет действие редактирования заявки
         * @param input ввод пользователя
         * @param tracker трекер с заявками
         */
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Enter The Order ID For Edit, Please: ");
            Order[] foundOrder = tracker.findById(id);
            if(foundOrder[0] != null){
                String name = input.ask("Enter The New Order Name, Please: ");
                String desc = input.ask("Enter The New Order Description, Please: ");
                Order order = new Order(name, desc);
                order.setId(id);
                tracker.editOrder(order);
                System.out.println("\n\nYour Order Is Edited Successfully!");
            } else {
                System.out.println("\nOrder Not Found For Edit! Order ID is Wrong!");
            }
        }
    }


    /**
     * Class RemoveOrder описывает действие удаления заявки
     * @author ablokhin
     * @since 15.01.2017
     * @version 1
     */
    private class RemoveOrder extends BaseAction{

        public RemoveOrder(String name){
            super(name);
        }

        /**
         * Метод key возвращает ключ действия пользователя
         * return возвращает 3 - ключ действия удаления заявки
         */
        public int key() {
            return 3;
        }

        /**
         * Метод execute осуществляет действие удаления заявки
         * @param input ввод пользователя
         * @param tracker трекер с заявками
         */
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Enter The Order ID For Remove, Please: ");
            if(tracker.removeOrder(id)){
                System.out.println("\nYour Order Is Removed Successfully!");
            } else {
                System.out.println("\nOrder Not Found For Remove! Order ID is Wrong!");
            }
        }
    }


    /**
     * Class FindOrderForThePeriod описывает действие поиска заявок по периоду
     * @author ablokhin
     * @since 15.01.2017
     * @version 1
     */
    private class FindOrderForThePeriod extends BaseAction{

        public FindOrderForThePeriod(String name){
            super(name);
        }

        /**
         * Метод key возвращает ключ действия пользователя
         * return возвращает 4 - ключ действия поиска заявок по периоду
         */
        public int key() {
            return 4;
        }

        /**
         * Метод execute осуществляет действие поиска заявок по периоду
         * @param input ввод пользователя
         * @param tracker трекер с заявками
         */
        public void execute(Input input, Tracker tracker) {
            String dateFrom = input.ask("Enter The Start Date For Search, Please: ");
            String dateTo = input.ask("Enter The Finnish Date For Search, Please: ");
            Order[] findOrders = tracker.findOrder(dateFrom, dateTo);
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
    }


    /**
     * Class FindOrderByString описывает действие поиска заявок по строке
     * @author ablokhin
     * @since 15.01.2017
     * @version 1
     */
    private class FindOrderByString extends BaseAction{

        public FindOrderByString(String name){
            super(name);
        }

        /**
         * Метод key возвращает ключ действия пользователя
         * return возвращает 5 - ключ действия поиска заявок по строке
         */
        public int key() {
            return 5;
        }

        /**
         * Метод execute осуществляет действие поиска заявок по строке
         * @param input ввод пользователя
         * @param tracker трекер с заявками
         */
        public void execute(Input input, Tracker tracker) {
            String substring = input.ask("Enter The Substring For Search, Please: ");
            Order[] findOrders = tracker.findOrder(substring);
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
    }


    /**
     * Class ShowOrders описывает действие вывода всех заявок на жкран
     * @author ablokhin
     * @since 15.01.2017
     * @version 1
     */
    private static class ShowOrders extends BaseAction{

        public ShowOrders(String name){
            super(name);
        }

        /**
         * Метод key возвращает ключ действия пользователя
         * return возвращает 6 - ключ действия вывода всех заявок на жкран
         */
        public int key() {
            return 6;
        }

        /**
         * Метод execute осуществляет действие вывода всех заявок на жкран
         * @param input ввод пользователя
         * @param tracker трекер с заявками
         */
        public void execute(Input input, Tracker tracker) {
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
    }


    /**
     * Class AddComment описывает действие добавления комментария к заявке
     * @author ablokhin
     * @since 15.01.2017
     * @version 1
     */
    private class AddComment extends BaseAction{

        public AddComment(String name){
            super(name);
        }

        /**
         * Метод key возвращает ключ действия пользователя
         * return возвращает 7 - ключ действия добавления комментария к заявке
         */
        public int key() {
            return 7;
        }

        /**
         * Метод execute осуществляет действие добавления комментария к заявке
         * @param input ввод пользователя
         * @param tracker трекер с заявками
         */
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Enter The Order ID For Search The Order To Add The Comment, Please: ");
            Order[] foundOrder = tracker.findById(id);
            if(foundOrder[0] != null){
                String comment = input.ask("Enter The Comment To The Order, Please: ");
                tracker.commentToOrder(foundOrder[0], comment);
                System.out.println("\nYour Comment Is Added To The Order Successfully!");
            } else {
                System.out.println("\nThe Order Was Not Found For Your Comment! Order ID is Wrong!");
            }
        }
    }
}