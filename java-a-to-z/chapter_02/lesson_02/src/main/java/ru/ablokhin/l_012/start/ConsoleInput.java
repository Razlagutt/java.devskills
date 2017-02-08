package ru.ablokhin.l_012.start;

import java.util.Scanner;

public class ConsoleInput implements Input{
	private Scanner scanner = new Scanner(System.in);

	public String ask(String question){
		System.out.print(question);
		return scanner.nextLine();
	}

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