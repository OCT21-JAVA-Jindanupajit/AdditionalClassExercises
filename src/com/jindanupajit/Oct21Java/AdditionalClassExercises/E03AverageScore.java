package com.jindanupajit.Oct21Java.AdditionalClassExercises;

import com.jindanupajit.Oct21Java.Main;
import com.jindanupajit.Oct21Java.utils.Console;

import java.util.ArrayList;
import java.util.function.Consumer;

public class E03AverageScore {
    static {
        Main.addToMenu(3,"Average Score",E03AverageScore.class);
    }
    public static void main(String[] args) {
        ArrayList<Integer> scores = getScores();

        Consumer<ArrayList<Integer>> displayScore = score -> {
            float total = 0F;
            for(int i = 0; i < score.size(); ++i) {
                Console.println(String.valueOf(i+1) + "# = " + score.get(i));
                total += score.get(i);
            }

            Console.println(String.format("Average Score is %.2f",total/score.size()));
        };

        displayScore.accept(scores);
    }

    private static ArrayList<Integer> getScores() {
        ArrayList<Integer> scores = new ArrayList<Integer>();
        scores.ensureCapacity(10);
        for(int i = 0; i < 10; ++i) {
            do {
                scores.add(Console.nextInt(String.format("Enter Score #%d: ", i+1)));
                if (Console.isError()) {
                    scores.remove(scores.size()-1);
                    Console.println("Not a valid score, Try again!");
                }

            } while (Console.getandResetError());
        }

        return scores;
    }
}
