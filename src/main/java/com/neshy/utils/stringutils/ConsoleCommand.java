package com.neshy.utils.stringutils;

import java.util.HashMap;
import java.util.Map;
import com.neshy.utils.ScannerEx;

public class ConsoleCommand {
    
    @FunctionalInterface
    public interface Action {
        boolean execute();
        default int getParameterCount() {
            return 0;
        }
    }

    public static boolean debug = true;

    private String name = "Null";
    private String[] parameters = null;

    private boolean valid = false;
    
    private Action action = null;
    private final static Map<String, ConsoleCommand> instances = new HashMap<>();

    private static Thread CONSOLE_COMMANDS_THREAD;

    static {

        if(!isThreadActive()) {
            
            startThread();

        }

    }

    public ConsoleCommand(String name, Action action) {

        this.name = name;
        this.action = action;
        this.valid = true;

        // Console.printf("Command %s initialized with id %d\n", this.name, this.id);
        instances.put(this.name, this);

    }

    /**
     * 
     */
    private static void startThread() {

        CONSOLE_COMMANDS_THREAD = new Thread(
            () -> {
                while(true) {

                    String input = ScannerEx.nextString("");
                    ConsoleCommand command = instances.get(

                        StringUtils.findFirstWord(input).toLowerCase()

                    );

                    if(!command.isValidCommand()) {

                        Console.print("Invalid command!");

                    }
                    else {

                        command.parameters = StringUtils.findParameters(input);
                        command.onExecute("Command executed!");

                    }
                }
            }
        );
        CONSOLE_COMMANDS_THREAD.start();
    }

    private boolean isValidCommand() {

        return (this.valid);

    }

    private static boolean isThreadActive() {

        if(CONSOLE_COMMANDS_THREAD == null || !CONSOLE_COMMANDS_THREAD.isAlive()) {

            return false;

        }
        else return true;
    }

    private void onExecute(String message) {

        Console.printf("[ConsoleCommand - %s] %s", this.name, message);
        boolean result = this.action.execute();

        if(!result) {

            this.onFailed("Command failed!");

        }

    }

    private void onFailed(String message) {

        Console.printf("[ConsoleCommand - %s] %s", this.name, message);

    }

    public String[] getParameters() {
        return parameters;
    }

    public void setParameters(String[] parameters) {
        this.parameters = parameters;
    }

}