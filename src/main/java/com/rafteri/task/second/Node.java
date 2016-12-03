package com.rafteri.task.second;

/**
 * 07/10/16
 *
 * @author Dinar Rafikov (First Software Engineering Platform)
 * @version 1.0
 */
public class Node {
    private int code;
    private String value;
    private Node left;
    private Node right;

    public Node(String value, int code) {
        this.code = code;
        this.value = value;
        left = null;
        right = null;
    }

    public Node setLeft(Node left) {
        this.left = left;
        return this;
    }

    public Node setRight(Node right) {
        this.right = right;
        return this;
    }

    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;

        Node node = (Node) o;

        if (getCode() != node.getCode()) return false;
        return getValue() != null ? getValue().equals(node.getValue()) : node.getValue() == null;

    }

    @Override
    public int hashCode() {
        int result = getCode();
        result = 31 * result + (getValue() != null ? getValue().hashCode() : 0);
        return result;
    }
}
