package com.ly.tree;

import lombok.Data;

@Data
public class Node<T> {
    T val;
    Node left;
    Node right;

    public Node(T val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public Node() {
    }

    public Node(T val) {
        this(val,null,null);
    }
}
