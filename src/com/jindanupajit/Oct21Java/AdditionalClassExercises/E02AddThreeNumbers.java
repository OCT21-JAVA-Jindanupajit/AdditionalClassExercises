package com.jindanupajit.Oct21Java.AdditionalClassExercises;

import com.jindanupajit.Oct21Java.Main;
import com.jindanupajit.Oct21Java.utils.Console;

public class E02AddThreeNumbers {
    static {
        Main.addToMenu(2,"Add Three Numbers",E02AddThreeNumbers.class);
    }
    public static void main(String[] args) {

        int number1 = Console.nextInt("Enter first number: ");
        int number2 = Console.nextInt("Enter second number: ");
        int number3 = Console.nextInt("Enter third number: ");

        Console.println(String.format("%d + %d + %d = %d",number1,number2,number3, number1+number2+number3));
    }
}
