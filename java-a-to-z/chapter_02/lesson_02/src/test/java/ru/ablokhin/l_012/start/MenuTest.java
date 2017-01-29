package ru.ablokhin.l_012.start;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import ru.ablokhin.l_012.models.Order;

/**
 * Class MenuTest для тестирования работы с меню трекера
 * @author ablokhin
 * @since 15.01.2017
 * @version 1
 */
public class MenuTest {

    private Tracker tracker = new Tracker();

    private void autoTest(StubInput answers, Tracker tracker){
        Menu menu = new Menu(answers, this.tracker);
        menu.fillActions();
        int key = Integer.valueOf(answers.ask("Enter The Number 0-7 To Select The Menu Item, Please: "));
        menu.select(key);
    }

    @Test
    public void addOrderTest() throws Exception {
        StubInput stubInput = new StubInput(new String[] {
                "1", "First Order", "First Description", "0"});
        autoTest(stubInput, this.tracker);
        assertThat(this.tracker.showOrders()[0].getName(), is("First Order"));
    }

    @Test
    public void editOrderTest() throws Exception {
        StubInput stubInput = new StubInput(new String[] {
                "1", "First Order", "First Description", "0"});
        autoTest(stubInput, this.tracker);
        stubInput = new StubInput(new String[] {
                "2", this.tracker.showOrders()[0].getId(), "Edited Order", "Edited Description", "0"});
        autoTest(stubInput, this.tracker);
        assertThat(this.tracker.showOrders()[0].getName(), is("Edited Order"));
    }

    @Test
    public void showOrdersTest() throws Exception {
        StubInput stubInput = new StubInput(new String[] {
                "1", "First Order", "First Description", "0"});
        autoTest(stubInput, this.tracker);
        stubInput = new StubInput(new String[] {
                "1", "Second Order", "Second Description", "0"});
        autoTest(stubInput, this.tracker);
        assertThat(this.tracker.showOrders()[0].getName(), is("First Order"));
        assertThat(this.tracker.showOrders()[1].getName(), is("Second Order"));
    }

    @Test
    public void findByPeriodTest() throws Exception {
        StubInput stubInput = new StubInput(new String[] {
                "1", "First Order", "First Description", "0"});
        autoTest(stubInput, this.tracker);
        stubInput = new StubInput(new String[] {
                "4", "2016.08.01 12:12:12", "2017.08.30 12:12:12", "0"});
        autoTest(stubInput, this.tracker);
        assertThat(this.tracker.showOrders()[0].getName(), is("First Order"));
    }

    @Test
    public void findBySubStringTest() throws Exception {
        StubInput stubInput = new StubInput(new String[] {
                "1", "First Order", "First Description", "0"});
        autoTest(stubInput, this.tracker);
        stubInput = new StubInput(new String[] {
                "5", "di", "0"});
        autoTest(stubInput, this.tracker);
        assertThat(this.tracker.showOrders()[0].getName(), is("First Order"));
    }

    @Test
    public void addCommentTest() throws Exception {
        StubInput stubInput = new StubInput(new String[] {
                "1", "First Order", "First Description", "0"});
        autoTest(stubInput, this.tracker);
        stubInput = new StubInput(new String[] {
                "7", this.tracker.showOrders()[0].getId(), "First Comment", "0"});
        autoTest(stubInput, this.tracker);
        assertThat(this.tracker.showOrders()[0].getComments()[0], is("First Comment"));
    }

    @Test
    public void removeOrderTest() throws Exception {
        StubInput stubInput = new StubInput(new String[] {
                "1", "First Order", "First Description", "0"});
        autoTest(stubInput, this.tracker);
        stubInput = new StubInput(new String[] {
                "3", this.tracker.showOrders()[0].getId()});
        autoTest(stubInput, this.tracker);
        assertNull(this.tracker.showOrders()[0]);
    }
}