package ru.ablokhin.l_013.start;

public class Menu{
	private static final String GREETING = "Hello, User!";
	private static final String DESCRIPTION = "This Is Order Registration Application.";
	private static final String[] CHOICES = new String[]{"0. Exit",
									"1. Add Order",
									"2. Edit Order",
									"3. Remove Order",
									"4. Find Order By Period",
									"5. Find Order By String",
									"6. Show Order List",
									"7. Add The Comment To Order"};
	
	public String getGreeting(){
		return this.GREETING;
	}
	
	public String getDescription(){
		return this.DESCRIPTION;
	}
	
	public String[] getChoices(){
		return this.CHOICES;
	}
}