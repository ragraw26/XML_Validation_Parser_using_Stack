/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_1_xmlparser_stackarray;

/**
 *
 * @author Rajat
 */
class arrayStack {

    private Object[] data;
    private int index = 0;
    private int size = 0;

    public arrayStack() {
        super();
        this.size = 20;       
        data = new Object[this.size];
    }

    public void push(String o) {
        if (index >= size) {
            this.increaseSize();
        }
        this.data[index] = o;
        index++;
    }

    public Object pop() {
        if (index != 0) {
            Object obj = data[index - 1];
            this.data[index - 1] = null; // Deleted
            index--;
            return obj;
        } else {
            return null;
        }
    }

    public Object peek() throws RuntimeException {
        if (index != 0) {
            return this.data[index - 1];
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return index == 0 ? true : false;
    }

    private void increaseSize() {
        Object[] temp = new Object[size];
        size = size * 2;
        for (int i = 0; i < index; i++) {
            temp[i] = this.data[i];
        }
        this.data = new Object[this.size];
        for (int i = 0; i < index; i++) {
            this.data[i] = temp[i];
        }
    }
}
