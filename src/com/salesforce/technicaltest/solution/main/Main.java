package com.salesforce.technicaltest.solution.main;

import com.salesforce.technicaltest.solution.command.CommandFactory;
import com.salesforce.technicaltest.solution.command.CommandType;
import com.salesforce.technicaltest.solution.filesystem.FileSystem;

import java.io.*;
import java.nio.file.Files;
import java.util.List;

/**
 * Created by Terry on 3/18/2020.
 */
public class Main {

    public static void main(String args[]) {
        //set output file
        FileOutputStream outputFile = null;

        try {
            outputFile = new FileOutputStream("prog8.out");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setOut(new PrintStream(outputFile));

        //init file system with root as the current directory
        FileSystem fs = FileSystem.INSTANCE;
        System.out.println("Problem 5 by team X ");

        List<String> list = null;
        try {
            list = Files.readAllLines(new File("prog5.dat").toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        CommandFactory factory = new CommandFactory();

        for (int i = 0; i < list.size(); i++) {
            String input = list.get(i);
//            System.out.println("Command: " + input + " ");
            String[] inputArray = input.split("\\s+");

            if (inputArray[0].equals(CommandType.DIR.value)) {
                factory.getCommand(CommandType.DIR).execute(fs, input, null);
            } else if (inputArray[0].equals(CommandType.MKDIR.value)) {
                factory.getCommand(CommandType.MKDIR).execute(fs, input,inputArray[1]);
            } else if (inputArray[0].equals(CommandType.CD.value)) {
                factory.getCommand(CommandType.CD).execute(fs, input,inputArray[1]);
            } else if (inputArray[0].equals(CommandType.UP.value)) {
                factory.getCommand(CommandType.UP).execute(fs, input,null);
            } else {
                try {
                    throw new IllegalArgumentException("Input is not a valid command.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        System.out.print("End of problem 5 by team X ");
    }

}
