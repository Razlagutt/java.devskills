package ru.ablokhin.l_012.start;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Blokhin on 25.01.2017.
 */
public class MenuTest1 {
    @Test
    public void getGreeting() throws Exception {
        Input input = null;
        Tracker tracker = new Tracker();
        Menu menu = new Menu(input, tracker);
        assertThat(menu.getGreeting(), is("Hello, User!"));
    }

    @Test
    public void getDescription() throws Exception {
        Input input = null;
        Tracker tracker = new Tracker();
        Menu menu = new Menu(input, tracker);
        assertThat(menu.getDescription(), is("This Is Order Registration Application."));
    }

    @Test
    public void fillActions() throws Exception {

    }

    @Test
    public void select() throws Exception {
        Input input = new StubInput(new String[] {"1", "First Order", "First Description"});
        Tracker tracker = new Tracker();
        Menu menu = new Menu(input, tracker);
        menu.fillActions();
        int key = Integer.valueOf(input.ask("Enter The Number 0-7 To Select The Menu Item, Please: "));
        menu.select(key);
        assertThat(tracker.showOrders()[0].getName(), is("First Order"));
    }

    @Test
    public void show() throws Exception {

    }
}