package com.neshy.utils.stringutils;

import java.util.HashMap;
import java.util.Map;

public class Separator {
    
    private boolean initialized = false;
    private final boolean excludeZeroIndex;
    private final String separator;
    private final String name;
    private final int id;

    private final static Map<Integer, Separator> instances = new HashMap<>();
    private final static Map<String, Separator> instancesByName = new HashMap<>();

    private static int NEXT_ID = 0;

    public Separator (String separator, String name, boolean excludeZeroIndex) {
        this.separator = separator;
        this.name = name;
        this.excludeZeroIndex = excludeZeroIndex;

        this.initialized = true;
        this.id = NEXT_ID++;
        instances.put(this.id, this);
        instancesByName.put(this.name, this);

        Console.printf("Separator %s initialized with id %d\n", this.name, this.id);
    }

    public String apply(int index, String string) {

        Console.printf("applying separator %s to string %s (index: %d)\n", this.name, string, index);

        String separatorString = this.getString();

        if(index == 0 && this.excludesZero()) {
            
            return string;

        }
        else {

            return separatorString + string;

        }
    }
    public int getId() {

        return this.id;

    }

    public static Separator getInstance(int id) {

        return instances.get(id);

    }

    public static Separator getInstance(String name) {

        return instancesByName.get(name);

    }

    public boolean isInitialized() {
        return this.initialized;
    }

    public boolean excludesZero() {
        return this.excludeZeroIndex;
    }
    
    public String getString() {
        return this.separator;
    }

}