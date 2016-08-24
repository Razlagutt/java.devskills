package ru.ablokhin.l_02;

/**
 * Created by Blokhin on 15.08.2016.
 */
public class CalculatorMain {
    public static void main(String[] args){
        double first = Double.valueOf(args[0]);
        double second= Double.valueOf(args[1]);
        Calculator calculator = new Calculator();
        calculator.add(first, second);
        System.out.println(first + " + " + second + " = " + calculator.getResult());
        calculator.div(first, second);
        System.out.println(first + " / " + second + " = " + calculator.getResult());
        calculator.multiple(first, second);
        System.out.println(first + " * " + second + " = " + calculator.getResult());
        calculator.substruct(first, second);
        System.out.println(first + " - " + second + " = " + calculator.getResult());
    }
}
