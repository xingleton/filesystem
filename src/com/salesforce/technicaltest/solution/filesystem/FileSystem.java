package com.salesforce.technicaltest.solution.filesystem;

/**
 * Singleton to represent the file system.
 */
public enum FileSystem {
    INSTANCE;

    private Directory node = new Directory(null, "root");
    private int directoryCount = 1;

    public Directory getDirectory() {
        return node;
    }

    public void setDirectory(Directory directory) {
        node = directory;
    }

    public int getDirectoryCount() {return directoryCount; }

    public void incrementDirectoryCount() { directoryCount++; }
}
