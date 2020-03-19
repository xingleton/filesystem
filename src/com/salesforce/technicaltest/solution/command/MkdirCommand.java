package com.salesforce.technicaltest.solution.command;

import com.salesforce.technicaltest.solution.filesystem.Directory;
import com.salesforce.technicaltest.solution.filesystem.FileSystem;

import javax.naming.LimitExceededException;

public class MkdirCommand implements Command {
    @Override
    public void execute(FileSystem fs, String input, String name) {
        System.out.println("Command: " + input + " ");
        Directory node = fs.getDirectory();
        if (node.getSubdirectories().containsKey(name)) {
            System.out.println("Subdirectory already exists ");
            return;
        }
        if (fs.getDirectoryCount() == 5000) {
            try {
                throw new LimitExceededException();
            } catch (LimitExceededException e) {
                System.out.println(e.getMessage());
            }
            return;
        }
        Directory child = new Directory(node, name);
        node.getSubdirectories().put(child.getName(), child);
        fs.incrementDirectoryCount();
    }
}
