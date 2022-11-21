package me.zeroest.datastructure.list.linked;

public class Node<T> {
    public Node(T item) {
        this.item = item;
    }

    private T item;
//    private Node prev;
    private Node<T> next;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
