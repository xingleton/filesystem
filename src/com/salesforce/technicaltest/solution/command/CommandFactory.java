package com.salesforce.technicaltest.solution.command;

/**
 * Factory design pattern to
 */
public class CommandFactory {
    public Command getCommand(CommandType type) {
        Command cmd = null;
        switch (type) {
            case CD:
                cmd = new CdCommand();
                break;
            case DIR:
                cmd = new DirCommand();
                break;
            case MKDIR:
                cmd = new MkdirCommand();
                break;
            case UP:
                cmd = new UpCommand();
                break;
            default:
                try {
                    throw new IllegalArgumentException("Input is not a valid command.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
        }
        return cmd;
    }
}
