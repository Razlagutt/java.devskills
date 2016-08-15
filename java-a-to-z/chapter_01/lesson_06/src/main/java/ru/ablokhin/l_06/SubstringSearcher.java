package ru.ablokhin.l_06;

/**
 * Класс поиска подстроки в строке
 * @author ablokhin
 * @since 12.08.2016
 * @version 1
*/
public class SubstringSearcher {

	/** 
	* Поиск подстроки
	* @param origin исходная строка
	* @param sub подстрока поиска
	* @return true, если sub является подстрокой иначе false
	*/
	public boolean contains(String origin, String sub){
		String[] basic_str = origin.split("");
		String[] sub_str = sub.split("");
		
		int basicLen = basic_str.length;
		int subLen = sub_str.length;
		int arrIndx = 0;
		boolean result = false;
		
		if( (subLen <= basicLen) && (subLen > 0) ){
			for( int i = 0; i < basicLen; i++ ){
				if( sub_str[arrIndx].equals(basic_str[i]) ){
					arrIndx++;					
				} else {
					arrIndx = 0;
					if( sub_str[arrIndx].equals(basic_str[i]) ) arrIndx++;
				}
				if (arrIndx == subLen){
					result = true;
					break;
				} 
			}			
		}
		return result;
	}
}