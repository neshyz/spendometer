package com.neshy;
import java.util.Scanner;
import com.neshy.utils.stringutils.Console;
import com.neshy.utils.stringutils.ConsoleCommand;
import com.neshy.utils.stringutils.StringUtils;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    
    static ConsoleCommand separatorCommand = new ConsoleCommand("separator",
            () -> {
                return separatorTest();
            }
    );

    public static void main(String[] args) {

        Sqlite handle = new Sqlite("database/database.db");

        // handle.newTable("my_expenses", "ID Integer PRIMARY KEY AUTOINCREMENT");

        while(true);
    }

    public static boolean separatorTest() {

        // String[] randomWords = {"apple", "banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon"};

        String[] parameters = separatorCommand.getParameters();

        Console.printf("parameters %s", StringUtils.separateArray(parameters, StringUtils.LINE_MINUS));

        return true;
    }
}
