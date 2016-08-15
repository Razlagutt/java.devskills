package ru.ablokhin.l_04;

/**
 * Класс для нахождения корней уравнения и значений функции
 * @author ablokhin
 * @since 14.08.2016
 * @version 1
*/
public class Square{

	private double a, b, c;
	
	public Square(double a, double b, double c){
			this.a = a;
			this.b = b;
			this.c = c;
	}
	
	/** 
	* Нахождения корней кадратного уравнения
	* @return массив корней уравнения
	*/
	public double[] calculate(){
		double[] roots = new double[2];
		double discriminant = Math.pow(this.b, 2) - 4 * this.a * this.c;
		if(discriminant > 0){
			roots[0] = (-this.b - Math.sqrt(discriminant)) / 2 * this.a;
			roots[1] = (-this.b + Math.sqrt(discriminant)) / 2 * this.a;
		} else if (discriminant < 0 ){
			System.out.println("The equation has no roots.");
		} else {
			roots[0] = -this.b / 2 * this.a;
			roots[1] = roots[0];
		}
		return roots;
	}
	
	/** 
	* Нахождения значений функции
	* @param start начало отрезка x1..x2
	* @param finish конец отрезка x1..x2
	* @param step шаг вычисления значений функции
	*/
	public void show(double start, double finish, double step){
		if( (start + step) <= finish ){
			double y = this.a * Math.pow(start, 2) + this.b + this.c;
			System.out.println("x = " + start + "; y = " + y);
			do{
				start = start + step;
				y = this.a * Math.pow(start, 2) + this.b + this.c;
				System.out.println("x = " + start + "; y = " + y);
			}while(start < finish);
		} else {
			System.out.println("Too big step!");
		}
	}
}