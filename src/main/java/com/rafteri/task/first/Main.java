package com.rafteri.task.first;

/**
 * 22.09.16
 *
 * @author Dinar Rafikov (First Software Engineering Platform)
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.read();
        list.show();
        list.deleteByCoef(list.findMaxCoef());
        list.show();
    }
}
