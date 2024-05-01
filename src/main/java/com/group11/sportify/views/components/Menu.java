package com.group11.sportify.views.components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Class that handles application menus.
 */
public class Menu {

    // Auxiliary interface to define the handler for each option
    public interface Handler {
        public void execute();
    }

    private static Scanner scanner = new Scanner(System.in);
    
    private List<String> options;
    private List<Handler> handlers;

    /**
     * Constructor for the Menu class.
     * @param options The options of the menu.
     */
    public Menu(String[] options) {
        this.options = Arrays.asList(options);
        this.handlers = new ArrayList<>();
        this.options.forEach(nullOption -> {
            this.handlers.add(null);
        });
    }

    /**
     * Sets the handler for an option.
     * @param i The index of the option.
     * @param h The handler for the option.
     */
    public void setHandler(int i, Handler h) {
        this.handlers.set(i, h);
    }

    /**
     * Display the menu and wait for the user to choose an option.
     * 
     * @return true if the user chose an option with a handler, false otherwise.
     */
    public boolean run() {
        for(int i = 0; i < options.size(); i++){
            System.out.println("["+ i + "] " + options.get(i));
        }

        while(true){
            System.out.print("|> ");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                if (choice >= 0 && choice < options.size()) {
                    if(this.handlers.get(choice) != null){
                        this.handlers.get(choice).execute();
                        return true;              
                    } else {
                        return false;
                    }
                }
            } else {
                scanner.next();
            }
        }
    }
}
