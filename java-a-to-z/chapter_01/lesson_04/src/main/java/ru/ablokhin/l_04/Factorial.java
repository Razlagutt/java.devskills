package ru.ablokhin.l_04;

/**
 * Класс для вычисления факториала
 * @author ablokhin
 * @since 11.08.2016
 * @version 1
*/
public class Factorial{

	private int number;

	Factorial(int number){
		this.number = number;
	}
	/** 
	* Вычисление факториала
	* @return вычисление факториала
	*/
	public double calculate(){
		if (this.number > -1){
			if(this.number==0 || this.number==1){
				System.out.println(this.number + "! = 1");
			} else {
				double factorial = 1;
				for(int i = this.number; i > 0; i--){
					factorial = factorial * i;
				}
				return factorial;
			}
		} else {
			System.out.println("You entered a negative number!");
		}
		return 0;
	}
}