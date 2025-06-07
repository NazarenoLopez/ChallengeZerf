package org.example.domain;

import lombok.Getter;

@Getter
abstract class Node {
    String name;
    Directory parent;

    public Node(String name, Directory parent) {
        this.name = name;
        this.parent = parent;
    }


}

