package com.jindanupajit.Oct21Java.AdditionalClassExercises;

import com.jindanupajit.Oct21Java.Main;
import com.jindanupajit.Oct21Java.utils.Console;


public class E01BasicApplication {
    static {
        Main.addToMenu(1,"Basic Application",E01BasicApplication.class);
    }
    public static void main(String[] args) {


        int input = Console.nextInt("Enter a number: ");

        Console.println(String.format(" ((( %d + 5) x 2) -7) = %d",input,((input+5)*2)-7));
    }
}
