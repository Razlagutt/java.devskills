package ru.ablokhin.l_012.start;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import ru.ablokhin.l_012.models.Order;

/**
 * Created by Andrey on 21.08.2016.
 */
public class TrackerTest {

    @Test
    public void add() throws Exception {
        Order order = new Order("First Order", "This is the First Order For the Test");
        Tracker tracker = new Tracker();
        tracker.add(order);
        assertThat(tracker.showOrders()[0].getName(), is(order.getName()) );
    }

    @Test
    public void editOrder() throws Exception {
        Order testOrder = new Order("First Order is Changed","First Order Was Changed");
        testOrder.setId("123456");

        Order order = new Order("First Order", "This is the First Order For the Test");
        Tracker tracker = new Tracker();
        tracker.add(order);
        tracker.showOrders()[0].setId("123456");

        boolean checked = tracker.editOrder("123456", "First Order is Changed", "First Order Was Changed");

        assertTrue(checked);
    }

    @Test
    public void findOrder() throws Exception {
        Order order = new Order("First Order", "This is the First Order For the Test");
        Tracker tracker = new Tracker();
        tracker.add(order);
        Order[] ordFind = tracker.findOrder("2016.07.30 12:12:12", "2018.08.30 23:23:23");
        assertThat(tracker.showOrders()[0], is(ordFind[0]));
    }

    @Test
    public void findOrder1() throws Exception {
        Order order = new Order("First Order", "This is the First Order For the Test");
        Tracker tracker = new Tracker();
        tracker.add(order);
        Order[] ordFind = tracker.findOrder("First");
        assertThat(tracker.showOrders()[0].getName(), is(ordFind[0].getName()));
    }

    @Test
    public void findById() throws Exception {
        Order order = new Order("First Order", "This is the First Order For the Test");
        order.setId("123456");
        Tracker tracker = new Tracker();
        tracker.add(order);
        Order[] ordFind = tracker.findById(order.getId());
        assertThat(tracker.showOrders()[0], is(ordFind[0]));
    }

    @Test
    public void removeOrder() throws Exception {
        Order order = new Order("First Order", "This is the First Order For the Test");
        Tracker tracker = new Tracker();
        tracker.add(order);
        tracker.showOrders()[0].setId("123456");
        assertThat(tracker.removeOrder(tracker.showOrders()[0].getId()), is(true));
    }
}