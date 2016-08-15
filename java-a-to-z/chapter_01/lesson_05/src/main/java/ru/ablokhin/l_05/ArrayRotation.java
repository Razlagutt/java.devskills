package ru.ablokhin.l_05;

/**
 * Класс для поворота массива на 90 градусов
 * @author ablokhin
 * @since 12.08.2016
 * @version 1
*/
public class ArrayRotation{

	private int[][] arr;

	ArrayRotation(int[][] arr){
		this.arr = arr;
	}

	/** 
	* Поворот массива на 90 градусов
	* @return двумерный массив, повернутый на 90 градусов
	*/
	public int[][] rotate(){
		int arrLen = this.arr.length;
		int[][] rotatedArr = new int[arrLen][arrLen];
		for(int i = 0; i < arrLen; i++){
			for(int j = 0; j < arrLen; j++){
				rotatedArr[arrLen-j-1][i] = this.arr[i][j];
			}
		}
		return rotatedArr;
	}
}
