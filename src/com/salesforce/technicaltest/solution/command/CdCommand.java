package com.salesforce.technicaltest.solution.command;

import com.salesforce.technicaltest.solution.filesystem.Directory;
import com.salesforce.technicaltest.solution.filesystem.FileSystem;

public class CdCommand implements Command {
    @Override
    public void execute(FileSystem fs, String input, String name) {
        System.out.println("Command: " + input + " ");
        Directory node = fs.getDirectory();
        if (node.getSubdirectories() == null || !node.getSubdirectories().containsKey(name)) {
            System.out.println("Subdirectory does not exist ");
            return;
        }
        fs.setDirectory(node.getSubdirectories().get(name));
    }
}
