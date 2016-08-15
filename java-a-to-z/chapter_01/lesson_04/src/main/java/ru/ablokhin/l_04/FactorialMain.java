package ru.ablokhin.l_04;

/**
 * Created by Blokhin on 15.08.2016.
 */
public class FactorialMain {
    public static void main(String[] args) {
        int number = Integer.parseInt(args[0]);
        Factorial factorial = new Factorial(number);
        double result = factorial.calculate();
        if(result != 0) System.out.println(number + "! = " + result);
    }
}
