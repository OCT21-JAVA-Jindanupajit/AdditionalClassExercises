package com.jindanupajit.Oct21Java.AdditionalClassExercises;

import com.jindanupajit.Oct21Java.Main;
import com.jindanupajit.Oct21Java.utils.Console;

import java.util.Random;
import java.util.function.Supplier;

public class E05GuessingGame {
    static {
        Main.addToMenu(5,"Guessing Game",E05GuessingGame.class);
    }

    public static void main(String[] args) {
        Supplier<Integer> randomNumber = () ->{
                return (new Random()).nextInt(10)+1;
        };

        int secret = randomNumber.get();
        int input;

        Console.println("I have chosen a number between 1 and 10. Try to guess it. ");

        do {

            input = Console.nextInt("Your guess: ");

            if (secret != input)
                Console.println("That is incorrect. Guess again.");

        }while(secret != input);

        Console.println("That's right! You're a good guesser.");
    }
}
