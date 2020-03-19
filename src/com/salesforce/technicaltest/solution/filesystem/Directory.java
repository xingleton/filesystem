package com.salesforce.technicaltest.solution.filesystem;

import java.util.TreeMap;

/**
 * Define Directory object
 * 1. Directory has it's name
 * 2. All directory has one parent except root which has no parent
 * 3. store of subdirectories (children) in a treemap. Subdirectory's name as key and value is pointer to it's sub directory,
 *    Treemap sorted by key by default, so it can easily iterator all the children by
 */
public class Directory {
    Directory parent;
    String name;
    TreeMap<String, Directory> subdirectories;

    public Directory(Directory parent, String name){
        this.parent = parent;
        this.name = name;
        subdirectories = new TreeMap<>();
    }

    public TreeMap<String, Directory> getSubdirectories() {
        return this.subdirectories;
    }

    public String getName() {
        return this.name;
    }

    public Directory getParent() {
        return this.parent;
    }
}
