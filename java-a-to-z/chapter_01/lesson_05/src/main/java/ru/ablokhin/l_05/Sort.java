package ru.ablokhin.l_05;

/**
 * Класс сортировки массива методом пузырька
 * @author ablokhin
 * @since 12.08.2016
 * @version 1
*/
public class Sort{

	private int[] arr;

	Sort(int[] arr){
		this.arr = arr;
	}
	
	/** 
	* Сортировка массива
	* @return this.arr отсортированный массив
	*/
	public int[] sort(){
		for(int i = this.arr.length - 1; i > 0; i--){
			for(int j = 0; j < i; j++){
				if(this.arr[j] > this.arr[j+1]){
					this.arr[j+1] = this.arr[j] + this.arr[j+1];
					this.arr[j] = this.arr[j+1] - this.arr[j];
					this.arr[j+1] = this.arr[j+1] - this.arr[j];
				}
			}
		}
		return this.arr;
	}
}
// 9 7 3 1 6 4 8 2 5