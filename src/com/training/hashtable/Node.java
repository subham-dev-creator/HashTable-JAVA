package com.training.hashtable;

public class Node<T>{

    private T Value;
    private Node<T> next;

    public Node(T value){
        this.Value=value;
        this.next=null;
    }

    public T getValue() {
        return Value;
    }

    public void setValue(T value) {
        Value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

}
