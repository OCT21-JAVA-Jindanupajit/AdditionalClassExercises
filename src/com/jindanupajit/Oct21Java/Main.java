package com.jindanupajit.Oct21Java;

import com.jindanupajit.Oct21Java.AdditionalClassExercises.*;
import com.jindanupajit.Oct21Java.utils.Console;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

public class Main {

    private static HashMap<Integer,MenuItem> menuItem = new HashMap<Integer,MenuItem>();

    public static void main(String[] args) {
    new E01BasicApplication();
    new E02AddThreeNumbers();
    new E03AverageScore();
    new E04MonopolyDice();
    new E05GuessingGame();

        try {



            int choice;
            do {
                Console.println("\n");
                Menu();
                Console.println("\n0: Quit\n");
                choice = Console.nextInt("Select an Application: ");


                if (menuItem.containsKey(choice)) {
                    Class cls = menuItem.get(choice).getClassReference();
                    Console.println("\n\n=== Invoke " + cls.getName() + " === \n\n");
                    Method method = cls.getMethod("main", String[].class);
                    method.invoke(null, (Object) null);
                    Console.println("\n\n=== " + cls.getName() + " Terminated! ===");
                }
                else if (choice != 0){
                    Console.print("Bad Choice!");
                }

            } while (choice != 0);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void addToMenu(int key,String label, Class reference) {
        menuItem.put(key,new MenuItem(label, reference));
    }
    private static void Menu() {

        Consumer<HashMap<Integer,MenuItem> >
                displayMenu = menu -> {
                    List<Integer> key = new ArrayList<>(menu.keySet());
                    Collections.sort(key);
                    while(!key.isEmpty()) {
                        int i = key.remove(0);
                        Console.println(i + ": " + menu.get(i).toString());
                    }
                };

        displayMenu.accept(menuItem);


    }
}

class MenuItem {
    private String label;
    private Class classReference;

    public MenuItem(String label, Class classReference) {
        this.label = label;
        this.classReference = classReference;
    }

    public String getLabel() {
        return label;
    }

    public Class getClassReference() {
        return classReference;
    }

    public String toString() {
        return label;
    }
}
