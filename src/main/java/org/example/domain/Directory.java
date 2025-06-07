package org.example.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
class Directory extends Node {
    private List<Node> children = new ArrayList<>();

    public Directory(String name, Directory parent) {
        super(name, parent);
    }

    public void addChild(Node node) {
        children.add(node);
    }

    public Node getChild(String name) {
        for (Node child : children) {
            if (child.getName().equals(name)) {
                return child;
            }
        }
        return null;
    }
}

