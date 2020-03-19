package com.salesforce.technicaltest.solution.command;

import com.salesforce.technicaltest.solution.filesystem.Directory;
import com.salesforce.technicaltest.solution.filesystem.FileSystem;

public class UpCommand implements Command {
    @Override
    public void execute(FileSystem fs, String input, String name) {
        System.out.println("Command: " + input + " ");
        Directory node = fs.getDirectory();
        if(node.getParent() == null) {
            System.out.println("Cannot move up from root directory ");
            return;
        }
        fs.setDirectory(node.getParent());
    }
}
