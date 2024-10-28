package com.neshy.utils.stringutils;

public class Console {

    // -- UTILS ----

    public static void print(String[] message) {

        for(String str : message) {
            print(str);
        }

    }
    public static void print(String message) {
        System.out.println(message);
    }

    public static void printError(String message) {
        System.err.println(message);
    }

    public static void printError(Exception e) {
        System.err.println(e.getMessage());
    }

    public static void printError(String message, Exception e) {
        System.err.printf("%s (message: %s)%n", message, e.getMessage());
    }

    public static void printError(String message, String e) {
        System.err.printf("%s (message: %s)%n", message, e);
    }

    public static void printf(String message, Object... args) {

        print(
            message.formatted(args)
        );

    }

    // public static void printf(String message, Object[]... args) {

    //     print(String.format(message, (Object[]) args));
    //     print("");

    // }

    public static void printException(Exception e) {
        System.err.println(e.getMessage());
    }
}
