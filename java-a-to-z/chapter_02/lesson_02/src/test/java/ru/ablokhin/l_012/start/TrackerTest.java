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
        Order order = new Order("First Order", "This is the First Order For the Test");
        Tracker tracker = new Tracker();
        tracker.add(order);
        tracker.editOrder("First Order").setDescription("First Order Change To Second");
        assertThat(tracker.showOrders()[0].getDescription(), is(order.getDescription()));
    }

    @Test
    public void findOrder() throws Exception {
        Order order = new Order("First Order", "This is the First Order For the Test");
        Tracker tracker = new Tracker();
        tracker.add(order);
        Order[] ordFind = tracker.findOrder("2016.07.30 12:12:12", "2016.08.22 23:23:23");
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
    public void commentToOrder() throws Exception {
        Order order = new Order("First Order", "This is the First Order For the Test");
        Tracker tracker = new Tracker();
        tracker.add(order);
        tracker.commentToOrder("First Order", "Great Service!");
    }

    @Test
    public void removeOrder() throws Exception {
        Order order = new Order("First Order", "This is the First Order For the Test");
        Tracker tracker = new Tracker();
        tracker.add(order);
        assertThat(tracker.removeOrder(order.getName()), is(true));
    }
}