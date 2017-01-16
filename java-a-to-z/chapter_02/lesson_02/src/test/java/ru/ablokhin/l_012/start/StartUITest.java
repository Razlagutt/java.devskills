package ru.ablokhin.l_012.start;

/**
 * Created by Blokhin on 22.08.2016.
 */
public class StartUITest {
    public static void main(String[] args) {
        Input input = new StubInput(new String[] {
                "1", "First Order", "First Description",
                "6",
                "2", "Edited Order", "Edited Description",
                "6",
                "4", "2016.08.01 12:12:12", "2016.08.30 12:12:12",
                "5", "di",
                "7", "First Comment",
                "6",
                "3",
                "0"
        });
        new InitTest(input).init();
    }
}