package ru.ablokhin.l_04;

public class SquareMain {
	public static void main(String[] args){
		double a = Double.valueOf(args[0]);
		double b = Double.valueOf(args[1]);
		double c = Double.valueOf(args[2]);
		double step = Double.valueOf(args[3]);
		
		Square square = new Square(a, b, c);
		double[] roots = square.calculate();
		System.out.println("\n" + a + "x*x + " + b + "x + " + c + " = 0");
		System.out.println("x1 = " + roots[0] + "; x2 = " + roots[1]);
		System.out.println("\ny = " + a + "x*x + " + b + "x + " + c);
		square.show(roots[0], roots[1], step);
	}
}