package ru.ablokhin.l_06;

/**
 * Created by Andrey on 15.08.2016.
 */
public class SubstringSearcherMain {
    public static void main(String[] args) {
        String basic_str = "You got no guts!";
        SubstringSearcher substringSearcher = new SubstringSearcher();
        boolean isSubstring = substringSearcher.contains(basic_str, args[0]);

        if (isSubstring) {
            System.out.println("\"" + args[0] + "\" is substring");
        } else {
            System.out.println("\"" + args[0] + "\" isn't substring");
        }
    }
}
