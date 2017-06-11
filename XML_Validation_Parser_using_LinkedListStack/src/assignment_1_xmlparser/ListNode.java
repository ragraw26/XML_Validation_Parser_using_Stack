/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_1_xmlparser;

/**
 *
 * @author Rajat
 */
/**
 * ListNode.java
 *
 *
 * @param <E>	the intended data type to be stored
 */
public class ListNode<E> {
    // Instance variables

    private E data;
    private ListNode<E> next;

 
    public ListNode(E d) {
        data = d;
        next = null;
    }

    public ListNode(E d, ListNode<E> n) {
        data = d;
        next = n;
    }


    public E getData() {
        return data;
    }


    public void setData(E d) {
        data = d;
    }

    public ListNode<E> getNext() {
        return next;
    }

    public void setNext(ListNode<E> n) {
        next = n;
    }
}
