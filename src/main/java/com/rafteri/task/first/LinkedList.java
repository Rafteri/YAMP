package com.rafteri.task.first;

import java.util.Scanner;

/**
 * 16.09.16
 *
 * @author Dinar Rafikov (First Software Engineering Platform)
 * @version 1.0
 */
public class LinkedList {
    private Node first;
    private Node last;
    private Scanner scanner;

    public LinkedList() {
        this.first = null;
        this.last = null;
    }

    public void read() {
        scanner = new Scanner(System.in);
        System.out.println("Вводите сначала коэффициент потом через пробел экспоненту. Для прекращения введите любое слово или символ.");
        readPolinoms();
        System.out.println("Считывание закончено!");
    }

    private void readPolinoms() {
        if (scanner.hasNextDouble()) {
            Double coef = scanner.nextDouble();
            if (scanner.hasNextBigInteger()) {
                Integer exp = scanner.nextInt();
                if (first == null) {
                    first = new Node(coef, exp);
                    last = first;
                } else {
                    last.setNext(new Node(coef, exp));
                    last = last.getNext();
                }
                readPolinoms();
            }
        }
    }

    public void show() {
        System.out.print("P=");
        if (first != null) {
            showElem(first);
        } else {
            System.out.println("0;");
        }
    }

    private void showElem(Node p) {
        System.out.print(p.toString());
        if (p.getNext() != null) {
            System.out.print(" + ");
            showElem(p.getNext());
            return;
        }
        System.out.println(";");
    }

    public Double findMaxCoef() {
        if (first != null) {
            return findMaxCoef(first.getNext(), first.getCoef());
        }
        System.out.println("List is empty");
        System.exit(1);
        return null;
    }

    private Double findMaxCoef(Node p, Double d) {
        if (p == null) {
            return d;
        } else if (p.getNext() == null) {
            if (p.getCoef() > d) {
                return p.getCoef();
            } else {
                return d;
            }
        } else {
            if (d < p.getCoef()) {
                d = p.getCoef();
            }
            return findMaxCoef(p.getNext(), d);
        }
    }

    public void deleteByCoef(Double coef) {
        if (first != null) {
            deleteByCoef(null, first, coef);
        }
    }

    private void deleteByCoef(Node bef, Node cur, Double coef) {
        if (cur == null) {
            return;
        } else if (bef == null) {
            if (cur.getCoef().equals(coef)) {
                first = cur.getNext();
                deleteByCoef(null, first, coef);
            } else {
                deleteByCoef(cur, cur.getNext(), coef);
            }
        } else {
            if (cur.getCoef().equals(coef)) {
                bef.setNext(cur.getNext());
                deleteByCoef(bef, cur.getNext(), coef);
            }
            deleteByCoef(cur, cur.getNext(), coef);
        }
    }
}
