package ru.ablokhin.l_012.start;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Andrey on 08.02.2017.
 */
public class ValidateInputTest {

    int value;

    public  void initTestValidateInput(String[] answers){
        StubValidateInput validateInput = new StubValidateInput(answers);
        Tracker tracker = new Tracker();
        Menu menu = new Menu(validateInput, tracker);
        UserAction[] actions = menu.fillActions();
        value = validateInput.ask("Enter The Number 0-7 To Select The Menu Item, Please: ", actions);
    }

    @Test
    public void askWhenNoThisItemInTheMenu() throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        initTestValidateInput(new String[] {"13", "0"});
        assertThat(out.toString(), is("\nThere Is No This Item In The Menu!\n\r\n"));
    }

    @Test
    public void askWhenEnterInvalidData() throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        initTestValidateInput(new String[] {"First Order", "0"});
        assertThat(out.toString(), is("\nPlease Enter Validate Data Again!\n\r\n"));
    }

    @Test
    public void askWhenEnterValidData() throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        initTestValidateInput(new String[] {"0"});
        assertThat(value, is(0));
    }
}