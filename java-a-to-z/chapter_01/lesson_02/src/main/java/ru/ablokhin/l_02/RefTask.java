package ru.ablokhin.l_02;

public class RefTask{
	public static void main(String[] args) {
		
		Integer value = 1;
		RefTask.change(value);
		System.out.println(value);
	}

	public static void change(Integer value) {

		value++;
	}

}
// Ошибка. Отсутствует фигурная скобочка
// Ошибка. Неправильно написано public (publib)
// Вывод 1, потому что инкриментация ссылочного типа не допустимо.