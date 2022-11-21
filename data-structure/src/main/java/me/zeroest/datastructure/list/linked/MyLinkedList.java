package me.zeroest.datastructure.list.linked;

import me.zeroest.datastructure.list.MyList;

import java.util.Objects;

public class MyLinkedList<T> implements MyList<T> {

    private Node<T> head;
    private int numberOfItems;

    public MyLinkedList() {
        this.head = new Node<>(null); // dummy
        this.numberOfItems = 0;
    }

    private Node<T> getNode(int idx) {
        if (numberOfItems-1 < idx) {
            return null;
        }

        Node<T> target = this.head;

        while (idx-- >= 0) {
            Node<T> next = target.getNext();
            if (Objects.isNull(next)) {
                break;
            }
            target = next;
        }

        return target;
    }

    private Node<T> getLastNode() {
        Node<T> target = this.head;

        while (Objects.nonNull(target.getNext())) {
            target = target.getNext();
        }

        return target;
    }

    private int getDataNode(T data) {
        Node<T> target = this.head;
        int idx = -1;

        while (Objects.nonNull(target.getNext())) {
            target = target.getNext();
            idx++;

            if (target.getItem().equals(data)) {
                return idx;
            }
        }

        return -1;
    }

    @Override
    public void add(int idx, T data) {
        if (idx >= 0 && idx < numberOfItems) {
            Node<T> prevNode = getNode(idx - 1);
            Node<T> newNode = new Node<>(data);
            newNode.setNext(prevNode.getNext());
            prevNode.setNext(newNode);
            numberOfItems++;
        }
    }

    @Override
    public void append(T data) {
        Node<T> lastNode = getLastNode();
        Node<T> newNode = new Node<>(data);
        lastNode.setNext(newNode);
        numberOfItems++;
    }

    @Override
    public T remove(int idx) {
        if (idx >= 0 && idx < numberOfItems) {
            Node<T> prevNode = getNode(idx - 1);
            Node<T> toRemoveNode = prevNode.getNext();
            Node<T> nextNode = toRemoveNode.getNext();

            toRemoveNode.setNext(null);
            prevNode.setNext(nextNode);
            numberOfItems--;

            return toRemoveNode.getItem();
        } else {
            return null;
        }
    }

    @Override
    public boolean remove(T data) {
        int targetIdx = getDataNode(data);
        if (targetIdx == -1) {
            return false;
        }

        remove(targetIdx);
        return true;
    }

    @Override
    public T get(int idx) {
        Node<T> node = getNode(idx);
        if (Objects.isNull(node)) {
            return null;
        }
        return node.getItem();
    }

    @Override
    public void set(int idx, T data) {
        Node<T> node = getNode(idx);
        if (Objects.nonNull(node)) {
            node.setItem(data);
        }
    }

    @Override
    public int indexOf(T data) {
        int targetIdx = getDataNode(data);
        return targetIdx;
    }

    @Override
    public int size() {
        return numberOfItems;
    }

    @Override
    public boolean isEmpty() {
        return numberOfItems == 0;
    }

    @Override
    public void clear() {
        this.head.setNext(null);
        this.numberOfItems = 0;
    }

    @Override
    public String toString() {
        Node<T> target = this.head;
        StringBuilder sb = new StringBuilder();

        sb.append("[ ");
        while (Objects.nonNull(target.getNext())) {
            target = target.getNext();
            sb.append(target.getItem());
            sb.append(", ");
        }
        sb.append("]");

        return sb.toString();
    }
}
