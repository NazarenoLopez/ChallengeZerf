package org.example.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class FileSystem {
    private Directory root;
    private Directory current;

    public FileSystem() {
        root = new Directory("home", null);
        current = new Directory("nazareno", root);
        current.getParent().addChild(current);
    }

    public void mkdir(String name) {
        if (current.getChild(name) != null) {
            System.out.println("Directory already exists");
            return;
        }
        current.addChild(new Directory(name, current));
    }

    public void touch(String name) {
        if (current.getChild(name) != null) {
            System.out.println("File already exists");
            return;
        }
        current.addChild(new File(name, current));
    }

    public void ls() {
        for (Node node : current.getChildren()) {
            System.out.println(node.getName());
        }
    }

    public void cd(String path) {
        if(path == null){
            current = root;
            return;
        }

        String[] parts = path.split("/");
        Directory target = current;

        for (String part : parts) {
            if (part.isEmpty() || part.equals(".")) {
                continue;
            } else if (part.equals("..")) {
                if (target.getParent() != null) {
                    target = target.getParent();
                }
            } else {
                Node next = target.getChild(part);
                if (next instanceof Directory) {
                    target = (Directory) next;
                } else {
                    System.out.println("cd: no such directory: " + part);
                    return;
                }
            }
        }

        current = target;
    }


    public void pwd() {
        List<String> path = new ArrayList<>();
        Node temp = current;
        while (temp != null) {
            path.addFirst(temp.getName());
            temp = temp.getParent();
        }
        System.out.println("/" + String.join("/", path));
    }

    public String getPrompt() {
        List<String> path = new ArrayList<>();
        Node temp = current;
        while (temp != null) {
            path.addFirst(temp.getName());
            temp = temp.getParent();
        }
        return "/" + String.join("/", path);
    }

}
