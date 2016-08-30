package ru.ablokhin.l_012.start;

import ru.ablokhin.l_012.models.Order;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Blokhin on 30.08.2016.
 */
public class InitTest {

    private String choice,param1, param2, param3;

    @Test
    public void init() throws Exception {

        /* Инициализация трекера*/
        Tracker tracker = new Tracker();

        /* Инициализация ввода*/
        Input consoleInput = new StubInput(new String[] {
                "1", "First Order", "First Description",
                "6",
                "2", "Edited Order", "Edited Description",
                "6",
                "4", "2016.08.01 12:12:12", "2016.09.30 12:12:12",
                "5", "di",
                "7", "First Comment",
                "6",
                "3",
                "0"
        });

        do {
            /* Выбор пользователя*/
            this.choice = consoleInput.ask("Enter The Number 0-7 To Select The Menu Item, Please: ");

            /* ADD ORDER*/
            if( this.choice.equals("1") ){
                this.param1 = consoleInput.ask("Enter The Order Name, Please: ");
                this.param2 = consoleInput.ask("Enter The Order Description, Please: ");
                Order order = new Order(this.param1, this.param2);
                tracker.add(order);

                assertThat(tracker.showOrders()[0].getName(), is(order.getName()) );
            }

            /* EDIT ORDER*/
            if( this.choice.equals("2") ){
                this.param1 = tracker.showOrders()[0].getId();
                this.param2 = consoleInput.ask("Enter The New Order Name, Please: ");
                this.param3 = consoleInput.ask("Enter The New Order Description, Please: ");
                Order newOrder = new Order(this.param2, this.param3);
                newOrder.setId(this.param1);

                assertTrue(tracker.editOrder(newOrder));
            }

            /* REMOVE ORDER*/
            if( this.choice.equals("3") ){
                this.param1 = tracker.showOrders()[0].getId();

                assertTrue(tracker.removeOrder(this.param1));
            }

            /* FIND ORDER FOR THE PERIOD*/
            if( this.choice.equals("4") ){
                this.param1 = consoleInput.ask("Enter The Start Date For Search, Please: ");
                this.param2 = consoleInput.ask("Enter The Finnish Date For Search, Please: ");
                Order[] findOrders = tracker.findOrder(this.param1, this.param2);

                assertTrue( tracker.showOrders()[0].getDate().isAfter( LocalDateTime.parse(this.param1,
                        DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss")))
                        && tracker.showOrders()[0].getDate().isBefore( LocalDateTime.parse(this.param2,
                        DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"))) );
            }

            /* FIND ORDER BY SUBSTRING*/
            if( this.choice.equals("5") ){
                this.param1 = consoleInput.ask("Enter The Substring For Search, Please: ");
                Order[] findOrders = tracker.findOrder(this.param1);

                assertThat(findOrders[0].getName(), is("E" + this.param1 + "ted Order"));
            }

            /* ADD COMMENT TO ORDER*/
            if( this.choice.equals("7") ){
                this.param1 = tracker.showOrders()[0].getId();
                this.param2 = consoleInput.ask("Enter The Comment To The Order, Please: ");

                assertTrue( tracker.commentToOrder(this.param1, this.param2) );
            }
        }while( !this.choice.equals("0") );

    }

}