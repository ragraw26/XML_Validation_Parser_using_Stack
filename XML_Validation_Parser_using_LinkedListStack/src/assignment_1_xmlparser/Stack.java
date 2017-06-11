/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_1_xmlparser;

import java.util.EmptyStackException;

/**
 *
 * @author Rajat
 */
public class Stack<E> {
    // Instance variables

    private ListNode<E> head;
    private int numItems;

    /**
     * Constructor creates an empty stack.
     */
    public Stack() {
        numItems = 0;
        head = null;
    }

    public void push(E item) {
        head = new ListNode<E>(item, head);
        numItems++;
    }

    public E pop() {
        if (numItems == 0) {
            throw new EmptyStackException();
        }

        ListNode<E> temp = head;
        head = head.getNext();
        numItems--;
        return temp.getData();
    }

    public E peek() {
        if (numItems == 0) {
            throw new EmptyStackException();
        }

        return head.getData();
    }

    public int size() {
        return numItems;
    }

    public boolean isEmpty() {
        return (numItems == 0);
    }
}
