package com.salesforce.technicaltest.solution.command;

import com.salesforce.technicaltest.solution.filesystem.FileSystem;

public interface Command {
    void execute(FileSystem fs, String input, String name);
}
