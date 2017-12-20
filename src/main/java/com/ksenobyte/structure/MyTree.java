package com.ksenobyte.structure;

import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class MyTree<T> {
    private Node<T> root;

    public MyTree(T value) {
        root = new Node<>();
        root.value = value;
        root.children = new ArrayList<>();
    }

    @EqualsAndHashCode(of = "value")
    public static class Node<T> {
        private T value;
        private Node<T> parent;
        private List<Node<T>> children = new ArrayList<>();

        public Node<T> addChild(T value) {
            Node<T> child = new Node<>();
            child.value = value;
            child.parent = this;
            this.children.add(child);
            return child;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", parent=" + (parent == null ? null : parent.value) +
                    ", children=" + children +
                    '}';
        }
    }

    public Node<T> getRoot() {
        return root;
    }

    public void removeByValue(T value) {
        Optional<Node<T>> nodeOpt = searchByValue(root, value);
        nodeOpt.ifPresent(this::deleteNode);
    }

    private void deleteNode(Node<T> node) {
        if (node.parent == null) {
            root = null;
            return;
        }
        node.parent.children.remove(node);
    }

    public Optional<Node<T>> searchByValue(Node<T> node, T value) {
        if (Objects.equals(node.value, value)) {
            return Optional.of(node);
        }
        for (Node<T> child : node.children) {
            Optional<Node<T>> result = searchByValue(child, value);
            if (result.isPresent()) {
                return result;
            }
        }

        return Optional.empty();
    }

    @Override
    public String toString() {
        return "MyTree{" +
                "root=" + root +
                '}';
    }
}