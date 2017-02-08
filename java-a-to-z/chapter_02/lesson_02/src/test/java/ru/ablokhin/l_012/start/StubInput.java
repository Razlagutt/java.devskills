package ru.ablokhin.l_012.start;

public class StubInput implements Input{
	
	private String[] answers;
	private int indx = 0;
	
	public StubInput(String[] answers){
		this.answers = answers;
	}
	
	public String ask(String question){
		return answers[indx++];
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