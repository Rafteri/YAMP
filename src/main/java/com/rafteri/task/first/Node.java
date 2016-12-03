package com.rafteri.task.first;

/**
 * 16.09.16
 *
 * @author Dinar Rafikov (First Software Engineering Platform)
 * @version 1.0
 */
public class Node {
    private Double coef;
    private Integer exp;
    private Node next;

    public Double getCoef() {
        return coef;
    }

    public Node setCoef(Double coef) {
        this.coef = coef;
        return this;
    }

    public Integer getExp() {
        return exp;
    }

    public Node setExp(Integer exp) {
        this.exp = exp;
        return this;
    }

    public Node getNext() {
        return next;
    }

    public Node setNext(Node next) {
        this.next = next;
        return this;
    }

    public Node(Double coef, Integer exp) {
        this.coef = coef;
        this.exp = exp;
        this.next = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;

        Node polinom = (Node) o;

        if (coef != null ? !coef.equals(polinom.coef) : polinom.coef != null) return false;
        if (exp != null ? !exp.equals(polinom.exp) : polinom.exp != null) return false;
        return next != null ? next.equals(polinom.next) : polinom.next == null;

    }

    @Override
    public int hashCode() {
        int result = coef != null ? coef.hashCode() : 0;
        result = 31 * result + (exp != null ? exp.hashCode() : 0);
        result = 31 * result + (next != null ? next.hashCode() : 0);
        return result;
    }

    public String toString() {
        return coef + "*x^" + exp;
    }
}
