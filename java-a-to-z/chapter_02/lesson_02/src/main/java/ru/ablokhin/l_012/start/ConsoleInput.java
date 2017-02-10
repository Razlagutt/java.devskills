package ru.ablokhin.l_012.start;

import java.util.Scanner;

/**
 * Class ConsoleInput обрабатывает ввод пользовательских данных
 * @author ablokhin
 * @since 10.02.2017
 * @version 1
 */
public class ConsoleInput implements Input{

	/* Поток ввода*/
	private Scanner scanner = new Scanner(System.in);

	/**
	 * Метод ask задает вопрос пользователю
	 * @param question вопрос пользователю
	 * @return возвращает ответ пользователя
	 */
	public String ask(String question){
		System.out.print(question);
		return scanner.nextLine();
	}

	/**
	 * Перегруженный метод ask задает вопрос пользователю
	 * @param question вопрос пользователю
	 * @param actionRange массив ответов
	 * @return возвращает ключ ответа из массива ответов
	 */
	public int ask(String question, UserAction[] actionRange){
		int key = Integer.valueOf(this.ask(question));
		boolean exist = false;
		for(UserAction action : actionRange){
			if(action.key() == key){
				exist = true;
				break;
			}
		}
		if(exist){
			return key;
		} else {
			throw new MenuOutException("Out Of Menu Range");
		}
	}
}