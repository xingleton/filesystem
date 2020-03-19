package com.salesforce.technicaltest.solution.command;

import com.salesforce.technicaltest.solution.filesystem.Directory;
import com.salesforce.technicaltest.solution.filesystem.FileSystem;

import java.util.Iterator;

public class DirCommand implements Command {
    @Override
    public void execute(FileSystem fs, String input, String name) {
        System.out.println("Command: " + input + " ");
        Directory node = fs.getDirectory();
        Directory curr = node;
        StringBuilder path = new StringBuilder();
        while(curr.getParent() != null){
            path.insert(0, "\\"+ curr.getName());
            curr = curr.getParent();
        }

        StringBuilder subdirectories = new StringBuilder();
        Iterator<String> it = node.getSubdirectories().keySet().iterator();
        while (it.hasNext()){
            subdirectories.append(it.next() + "    ");
        }

        if (subdirectories.length() == 0 ) {
            subdirectories.append("No subdirectories ");
        }
        System.out.println("Directory of root" + path.toString()  + ": ");
        System.out.println(subdirectories + " ");
    }
}
