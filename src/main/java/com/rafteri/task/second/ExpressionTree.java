package com.rafteri.task.second;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 07/10/16
 *
 * @author Dinar Rafikov (First Software Engineering Platform)
 * @version 1.0
 */
public class ExpressionTree {
    private Node root;
    private Node tempNode;
    private static final Pattern isOperator = Pattern.compile("[*/+-]");
    private String expression;

    public void Read() {
        expression = new Scanner(System.in)
                .nextLine()
                .trim()
                .replaceAll("s+", "");
        CreateTree(expression);
    }

    private void CreateTree(String expression) {
        int index = indexOfNextOperator(expression);
        if (expression.length() != 0 && index > 0) {
            BuildTree(index);
        } else {
            System.out.println("Incorrect expression!");
        }
    }

    private void BuildTree(int index) {
        String operator = expression.substring(index, index + 1);
        Node node = new Node(operator, 1);
        if (operator.matches("[*/]")) {
            if (tempNode == null) {
                node.setLeft(new Node(expression.substring(0, index), 2));
            } else {
                tempNode.setRight(new Node(expression.substring(0, index), 2));
                node.setLeft(tempNode);
            }
            tempNode = node;
            expression = expression.substring(index + 1);
        } else {
            if (root == null) {
                if (tempNode == null) {
                    node.setLeft(new Node(expression.substring(0, index), 2));
                } else {
                    tempNode.setRight(new Node(expression.substring(0, index), 2));
                    node.setLeft(tempNode);
                }
            } else {
                if (tempNode == null) {
                    root.setRight(new Node(expression.substring(0, index), 0));
                } else {
                    root.setRight(tempNode);
                }
                node.setLeft(root);
            }
            root = node;
            tempNode = null;
            expression = expression.substring(index + 1);
        }

        if (expression.length() != 0) {
            index = indexOfNextOperator(expression);
            if (index > 0) {
                BuildTree(index);
            } else {
                if (root != null) {
                    if (tempNode != null) {
                        tempNode.setRight(new Node(expression, 2));
                        expression = "";
                        root.setRight(tempNode);
                        tempNode = null;
                    } else {
                        root.setRight(new Node(expression, 2));
                        expression = "";
                    }
                } else {
                    root = tempNode;
                    tempNode.setRight(new Node(expression, 2));
                }
            }
        }
    }

    private int indexOfNextOperator(String expression) {
        Matcher matcher = isOperator.matcher(expression);
        return matcher.find() ? matcher.start() : -1;
    }


    public void Print() {
        if (root != null) {
            printTree(root);
        } else {
            System.out.println("Empty expression tree");
        }
    }

    private void printTree(Node node) {
        if (node != null) {
            if (node.getCode() == 1) {
                System.out.print("(" + node.getValue() + ", ");
                printTree(node.getLeft());
                System.out.print(", ");
                printTree(node.getRight());
                System.out.print(")");
            } else {
                System.out.print(node.getValue());
            }

        }
    }

}
