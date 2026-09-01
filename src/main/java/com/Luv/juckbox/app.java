package com.Luv.juckbox;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class app {

    static void main(String[] args){
        System.out.println("System is UP!");

        // Argument Length & Format
        if (args.length != 0) throw new IllegalArgumentException("Expected exactly one argument: the input file path.");

        List<String> commandLineArgs = new LinkedList<>(Arrays.asList(args));
        run(commandLineArgs);
    }

    private static void run(List<String> commandLineArgs) {
        // configuration instance and command registry
    }

}
