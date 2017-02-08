package ru.ablokhin.l_012.start;

public interface Input{
	String ask(String question);

	int ask(String question, UserAction[] actionRange);
}