package com.ksenobyte.structure;

public class MyLinkedList<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;

    private class Node<E> {
        private Node<E> left;
        private Node<E> right;
        private E value;
    }

    public void add(E e) {
        Node<E> node = new Node<>();
        node.left = this.last;
        node.value = e;
        if (first == null) {
            first = node;
        }
        if (last != null) {
            last.right = node;
        }
        last = node;
        size++;
    }

    public void addFirst(E e) {
        Node<E> node = new Node<>();
        node.value = e;
        node.right = first;
        first.left = node;
        first = node;
        size++;
    }

    public E get(int index) {
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.right;
        }
        return node.value;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            builder.append(node.value).append(" ");
            node = node.right;
        }
        return builder.toString();
    }
}

