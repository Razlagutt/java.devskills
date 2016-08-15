package ru.ablokhin.l_03;

/**
 * Класс для нахождения площади треугольника и максимальной его стороны
 * @author ablokhin
 * @since 10.08.2016
 * @version 1
*/

public class Triangle {

	/** Точки треугольника*/
	private Point a;
	private Point b;
	private Point c;

	/**
	 * Инициализация объекта (треугольник)
	 * @param a точка треугольника
	 * @param b точка треугольника
	 * @param c точка треугольника
	 */
	public Triangle(Point a, Point b, Point c) {

		this.a = a;
		this.b = b;
		this.c = c;
	}

	/** Вычисление площади треугольника
	* @return площадь треугольника
	*/
	public double area() {
 
		double result;

		double sideA = this.a.distanceTo(this.b);
		double sideB = this.a.distanceTo(this.c);
		double sideC = this.b.distanceTo(this.c);
		
		if( ( sideA < (sideB+sideC) ) &&
			( sideB < (sideA+sideC) ) &&
			( sideC < (sideA+sideB) ) ){
			double p = (sideA + sideB + sideC)/2;
			result = Math.sqrt(p*(p-sideA)*(p-sideB)*(p-sideC));
		} else {
			result = 0;
		}
		return result;
	}
	
	/**Вычисление максимальной стороны треугольника
	* @return максимальная длина стороны треугольника
	*/
	public double maxTriangleSide(){
		
		double sideA = this.a.distanceTo(this.b);
		double sideB = this.a.distanceTo(this.c);
		double sideC = this.b.distanceTo(this.c);
		
		return Math.max(sideA, Math.max(sideB, sideC));
	}
}