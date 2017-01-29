package ru.ablokhin.l_012.start;

/**
 * Class Init инициализирует работу с заявками
 * @author ablokhin
 * @since 15.01.2017
 * @version 3
 */
public class InitTest {

    private int key;
	private Input input;
	
	public InitTest(Input input){
		this.input = input;
	}

    void init() {

        Tracker tracker = new Tracker();

        /* Инициализация меню*/
        Menu menu = new Menu(input, tracker);

        /* Приветствие*/
        System.out.println(menu.getGreeting());

        /* Описание программы*/
        System.out.println(menu.getDescription());

        menu.fillActions();

        do {
            /* Вывод меню*/
            menu.show();

            /* Выбор пользователя*/
            key = Integer.valueOf(input.ask("Enter The Number 0-7 To Select The Menu Item, Please: "));
            menu.select(key);

        } while (key != 0);
    }
}
