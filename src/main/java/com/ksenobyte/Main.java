package com.ksenobyte;

import com.ksenobyte.structure.MyLinkedList;
import com.ksenobyte.structure.MyTree;

public class Main {
    public static void main(String[] args) {
//        testList();
        testTree();
    }

    private static void testList() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);

        list.addFirst(0);
        System.out.println(list);

        System.out.println(list.get(2));
    }

    private static void testTree() {
        MyTree<Integer> tree = new MyTree<>(0);
        MyTree.Node<Integer> root = tree.getRoot();
        MyTree.Node<Integer> child1 = root.addChild(1);
        MyTree.Node<Integer> child2 = root.addChild(2);
        child1.addChild(11);
        child1.addChild(12);
        child2.addChild(21);
        child2.addChild(22);
        System.out.println(tree);

        tree.searchByValue(root, 21).ifPresent(System.out::println);
        tree.searchByValue(root, 233).ifPresent(System.out::println);

        tree.removeByValue(0);
        System.out.println(tree);

    }
}
