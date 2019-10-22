package com.jindanupajit.Oct21Java.AdditionalClassExercises;

import com.jindanupajit.Oct21Java.Main;
import com.jindanupajit.Oct21Java.utils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.function.Supplier;

public class E04MonopolyDice {
    static {
        Main.addToMenu(4,"Monopoly Dice",E04MonopolyDice.class);
    }
    public static void main(String[] args) {
        Console.println("\nTest data: ");
        play(new ArrayList<Integer>(Arrays.asList(2, 6)));

        Console.println("\nTest data: ");
        play(new ArrayList<Integer>(Arrays.asList(3,3,1,2)));

        Console.println("\nTest data: ");
        play(new ArrayList<Integer>(Arrays.asList(2, 2, 1, 1, 6, 6)));

        Console.println("\nRandom: ");
        play(new ArrayList<Integer>());

    }
    private static void play (ArrayList <Integer> testValue) {

        Supplier<Integer> roll = () ->{

            // Use testValue until exhausted.
            if (testValue.isEmpty())
                return (new Random()).nextInt(6)+1;

            return testValue.remove(0);
        };

        int doubleCounter = 0;
        int diceOne;
        int diceTwo;


        do {
             diceOne = roll.get();
             diceTwo = roll.get();

             Console.println(String.format("User rolls %d & %d", diceOne, diceTwo));

             if (diceOne == diceTwo) {
                 Console.println("DOUBLES!");
                 if (++doubleCounter  >= 3) {
                    Console.println("GO TO JAIL --->");
                    break;
                 }
                 Console.println(String.format("Move %d Spaces and roll again getting...",diceOne+diceTwo));
             }
             else {
                 Console.println(String.format("Move %d Spaces and stop",diceOne+diceTwo));
                 break;
             }



        } while(true);

    }
}
