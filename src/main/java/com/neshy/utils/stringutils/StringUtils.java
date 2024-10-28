package com.neshy.utils.stringutils;

public class StringUtils {
    
    public static final Separator SPACE = new Separator(" ", "space", true);
    public static final Separator COMMA = new Separator(", ", "comma", true);
    public static final Separator LINE = new Separator("\n", "line", false);
    public static final Separator LINE_MINUS = new Separator("\n- ", "line_minus", false);

    public static String[] excludeIndex(String[] array, int index) {

        String[] new_array = new String[array.length - 1];

        int indexCounter = 0;

        for(String str : array) {

            if(str.equals(array[index])) {
                continue;
            }

            new_array[indexCounter] = str;
            indexCounter++;

        }

        return new_array;

    }

    public static String separateArray(String[] array, Separator separator) {

        String result = "";

        for(int index = 0; index < array.length; index++) {

            result += separator.apply(index, array[index]);

        }

        return result;
    }

    public static String separateArray(String[] array) {

        return separateArray(array, COMMA);

    }

    public static void separateArrayTest(String[] array) {

        Console.printf("Separated array: %s\n", separateArray(array));

    }

    public static String findFirstWord(String str) {

        String[] splitResult = str.split(" ");

        if(splitResult != null) {

            return splitResult[0];

        }
        else {

            return str;

        }

    }

    public static String[] findParameters(String str) {

        String[] splitResult = str.split(" ");

        if(splitResult != null) {

            return excludeIndex(splitResult, 0);

        }
        else {

            return new String[1];

        }

    } 

    public static String repeat(String str, Separator separator, int times) {

        String result = "";

        for(int index = 0; index < times; index++) {

            result += separator.apply(index, str);

        }

        return result;

    }
}

