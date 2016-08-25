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
}