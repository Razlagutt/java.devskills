package ru.ablokhin.l_05;

/**
 * Класс удаления дубликатов из массива
 * @author ablokhin
 * @since 12.08.2016
 * @version 1
*/
public class DublicateKiller{

	private String[] arr;

	DublicateKiller(String[] arr){
		this.arr = arr;
	}
	/** 
	* Удаление дубликатов из массива
	* @return массив, без дубликатов
	*/
	public String[] kill(){
		int arrLen = this.arr.length;
		int count = 0;
		while(count < arrLen - 1){
			for(int i = count + 1; i < arrLen; i++){
				if( this.arr[count].equals(this.arr[i]) ){
					this.arr[i] = "";
				}
			}
			count++;
		}
		for(int i = arrLen - 1; i > 0; i--){
			for(int j = 0; j < i; j++){
				if( this.arr[j].length() < this.arr[j+1].length() ){
					String tmp = this.arr[j];
					this.arr[j] = this.arr[j+1];
					this.arr[j+1] = tmp;
				}
			}
		}
		return this.arr;
	}
}
// 1 1 2 1 3 1 4 1 5 1 6 1 7 1 8 1 9 2