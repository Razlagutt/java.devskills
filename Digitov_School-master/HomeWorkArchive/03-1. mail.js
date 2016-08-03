
//1) Написать регулярное выражение для валидации e-mail. Пользователь вводит через модальное окно prompt() и обрабатывает эго с выводом в консоль:
//    - true или false (правильно введен e-mail или нет)
//- в сети много решений, но советую попытаться написать самостоятельно, чтобы вы разобрались с регулярными выражениями — если верно, то в консоли появляется сообщение
//«Email введен верно, домен почтового ящика пользователя — mail.ru»
//не весь адрес, а только домен, после @
//- если не верно то выводится alert с сообщением об ошибке
//

// Комментарий к ДЗ

// задача решена правильно, но попробуйте в целях самостоятельного обучения ее доработать для почтовых ящиков с двойным именем
// например пользователь с таким e-mail vasya.pupkin@mail.ru сейчас не может зарегистрироваться у Вас на сайте
// а также поскольку мы разобрались с циклом, предлагаю добавить повторный вызов окна prompt, если e-mail был введен не верно

// с уважением. Станислав Закорко

var email = prompt("Введите Ваш e-mail:");
while ( !(/^[a-zA-Z._0-9]+@\w+.\w{2,3}$/.test(email)) ){
	email = prompt("E-mail введен неверно. Введите Ваш e-mail:");
}
alert(email + " введен верно, домен почтового ящика пользователя — " + email.match(/\w+.\w+$/));