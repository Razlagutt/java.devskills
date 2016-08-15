package ru.ablokhin.l_03;

public class TriangleArea{
	public static void main(String[] args){
		
		Point pointA = new Point(1,1);
		Point pointB = new Point(1,3);
		Point pointC = new Point(3,2);

		Triangle triangle = new Triangle(pointA, pointB, pointC);
		double triangleArea = triangle.area();
		if(triangleArea > 0){
			System.out.println( "\nTriangle area = " + triangleArea);
		} else {
			System.out.println( "\nThe entered data does not belong to the triangle!" );
		}
		
		double maxSide = triangle.maxTriangleSide();
		System.out.println( "\nMax triangle side = " + maxSide);
	}
}