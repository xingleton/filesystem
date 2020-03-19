package com.salesforce.technicaltest.solution.command;

public enum CommandType {
    DIR("dir"),
    MKDIR("mkdir"),
    CD("cd"),
    UP("up");

    public final String value;

    private CommandType(String value) {
        this.value = value;
    }
}
