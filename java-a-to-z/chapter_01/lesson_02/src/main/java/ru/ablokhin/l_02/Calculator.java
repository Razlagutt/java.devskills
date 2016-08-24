package ru.ablokhin.l_02;

/**
 * Class Уласс для вычисления арифметических операций + - / *
 * @author ablokhin
 * @since 09.08.2016
 * @version 1
 */

public class Calculator{

	private double result;
	
	/**
	 * Сложение
	 * @param first первый аргумент
	 * @param second второй аргумент
	 */
	public void add(double first, double second){
		this.result = first + second;
	}

	/**
	 * Вычитание
	 * @param first первый аргумент
	 * @param second второй аргумент
	 */
	public void substruct(double first, double second){
		this.result = first - second;
	}

	/**
	 * Умножение
	 * @param first первый аргумент
	 * @param second второй аргумент
	 */
	public void multiple(double first, double second){
		this.result = first * second;
	}

	/**
	 * Деление
	 * @param first первый аргумент
	 * @param second второй аргумент
	 */
	public void div(double first, double second){
		this.result = first / second;
	}

	/**
	 * Вывод результата
	 * @return result результат арифметической операции
	 */	
	public double getResult(){
		return this.result;
	}
}