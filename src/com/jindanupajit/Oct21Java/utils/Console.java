package com.jindanupajit.Oct21Java.utils;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Scanner;

public class Console {
    private static Scanner scannerInstance= null;
    private static boolean error = false;

    public static boolean getandResetError() {
        boolean tmpval = error;
        if (error)
            getScanner().next();
        error = false;
        return tmpval;
    }

    public static boolean isError() {
        return error;
    }

    public static void print(String message) {
        System.out.print(OptionalString(Optional.of(message),"<null>"));
    }

    public static void println(String message) {
        System.out.println(OptionalString(Optional.of(message),"<null>"));
    }




    public static int nextInt(String prompt) {
        Prompt(prompt);
        return nextInt();
    }

    public static int nextInt() {
        error = false;
        try {
            return getScanner().nextInt();
        }
        catch (InputMismatchException ex) {
            ErrorMessage("Input Mismatch: Integer Expected!");
            return 0;
        }
        catch (NoSuchElementException ex) {
            ErrorMessage("Input is exhausted");
            return 0;
        }
        catch (IllegalStateException ex) {
            ErrorMessage("Keyboard scanner is closed");
            return 0;
        }
        catch (Exception ex) {
            ErrorMessage("Unknown error");
            return 0;
        }
    }

    private static Scanner getScanner() {
        if (scannerInstance == null) {
            scannerInstance = new Scanner(System.in);
        }
        return scannerInstance;
    }
    private static void Prompt(String prompt) {
        System.out.print(OptionalString(Optional.of(prompt),"> "));
    }

    private static void ErrorMessage(String message) {
        error = true;
        System.out.println("Keyboard Scanner Error: "+message);
    }

    private static String OptionalString(Optional<String> value) {
        return OptionalString(value,"");
    }
    private static String OptionalString(Optional<String> value, String defaultString) {
        if (value.isPresent())
            return value.get();

         return defaultString;

    }
}
