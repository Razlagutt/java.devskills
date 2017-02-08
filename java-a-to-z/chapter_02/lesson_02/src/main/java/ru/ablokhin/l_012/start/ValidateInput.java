package ru.ablokhin.l_012.start;

/**
 * Created by Andrey on 06.02.2017.
 */
public class ValidateInput extends ConsoleInput {

    public int ask(String question, UserAction[] actionRange) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, actionRange);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("\nThere Is No This Item In The Menu!\n");
            } catch (NumberFormatException nfe){
                System.out.println("\nPlease Enter Validate Data Again!\n");
            }
        } while(invalid);
        return value;
    }
}
