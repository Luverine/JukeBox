package com.Luv.juckbox;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.module.Configuration;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class App {

    static void main(String[] args){
        System.out.println("System is UP!");

        // Argument Length & Format
        if (args.length != 0) throw new IllegalArgumentException("Expected exactly one argument: the input file path.");

        List<String> commandLineArgs = new LinkedList<>(Arrays.asList(args));
        run(commandLineArgs);
    }

    static void run(List<String> commandLineArgs) {
        // configuration instance and command registry
        Configuration conf = Configuration.getInstance();
        ComandRegistry comandRegistry = conf.getCommandRegistry();

        // Extract the input file path
        String inputFile;
        if(commandLineArgs.get(0).contains("=")) inputFile = commandLineArgs.get(0).split("=")[1]; // Extract filename if key-value format
        else inputFile = commandLineArgs.get(0); // Direct filename case

        // Read commands from the file and execute them
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Ensure the line is not empty or whitespace before invoking the command
                if (!line.trim().isEmpty()) comandRegistry.invokeCommand(line);
            }
        } catch (Exception e) {
            // Gracefully handle exceptions and log an error message
            System.err.println("Error reading input file: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
