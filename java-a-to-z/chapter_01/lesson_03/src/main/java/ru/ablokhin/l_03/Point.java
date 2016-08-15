package ru.ablokhin.l_03;

/**
 * Class Класс для вычисления длины сторон треугольника
 * @author ablokhin
 * @since 10.08.2016
 * @version 1
 */

public class Point {

	/** координаты точек треугольника*/
	private double x;
	private double y;

	/**
	 * Инициализация объекта (точки)
	 * @param x значение по оси абсцисс
	 * @param y значение по оси ординат
	 */
	public Point(double x, double y) {

		this.x = x;
		this.y = y;
	}

	/**
     * Метод вычисления длины сторон треугольника
     * @param point точка до которой рассчитывается расстояние
     * @return длина стороны треугольника
     */
	public double distanceTo(Point point) {

		return Math.sqrt(Math.pow(point.x - this.x,2) + Math.pow(point.y - this.y,2));
	}
}