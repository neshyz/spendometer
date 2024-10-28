package com.neshy.utils;

import java.util.Scanner;
import com.neshy.utils.stringutils.Console;

public class ScannerEx {
    
    static Scanner scanner = new Scanner(System.in);

    static public int nextInt(String message) {
        Console.printf("%s", message);
        return scanner.nextInt();
    }

    static public String nextString(String message) {
        Console.printf("%s", message);
        return scanner.nextLine();
    }

    static public double nextDouble(String message) {
        Console.printf("%s", message);
        return scanner.nextDouble();
    }

    static public float nextFloat(String message) {
        Console.printf("%s", message);
        return scanner.nextFloat();
    }

    static public long nextLong(String message) {
        Console.printf("%s", message);
        return scanner.nextLong();
    }

    static public short nextShort(String message) {
        Console.printf("%s", message);
        return scanner.nextShort();
    }

    static public byte nextByte(String message) {
        Console.printf("%s", message);
        return scanner.nextByte();
    }

    static public boolean nextBoolean(String message) {
        Console.printf("%s", message);
        return scanner.nextBoolean();
    }

}
