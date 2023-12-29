package org.example.recursion.tree;


import java.util.ArrayList;
import java.util.List;

public class TreeHeight {

    public static void main(String[] args) {
//        System.out.println(height(tree()));
        System.out.println(average(tree()));
    }

    public static final int ROOT_INDEX = 0;


    /**
     *                  0
     *               /     \
     *             /        \
     *           /           \
     *         /              \
     *       1                2
     *     /   \            /  \
     *    3     4         5      6
     *   / \   /  \     / \     / \
     *  7  8  9   10  11  12  13  14
     *
     *
     **/
    public static Node tree() {
        var node14 = new Node(null, null, 14);
        var node13 = new Node(null, null, 13);
        var node12 = new Node(null, null, 12);
        var node11 = new Node(null, null, 11);
        var node10 = new Node(null, null, 10);
        var node9 = new Node(null, null, 9);
        var node8 = new Node(null, null, 8);
        var node7 = new Node(null, null, 7);
        var node6 = new Node(node13, node14, 6);
        var node5 = new Node(node11, node12, 5);
        var node4 = new Node(node9, node10, 4);
        var node3 = new Node(node7, node8, 3);
        var node2 = new Node(node5, node6, 2);
        var node1 = new Node(node3, node4, 1);
        var node0 = new Node(node1, node2, ROOT_INDEX);
        return node0;
    }

    static int height(Node node){
        if (node == null) {
            return 0;
        }

        int left = height(node.getLeftNode()) + 1;
        int right = height(node.getRightNode()) + 1;

        return Math.max(left, right);
    }

    static List<Double> average(Node node){
        List<Double> result = new ArrayList<>(); //suma elementow na kazdym poziomie
        List<Integer> elements = new ArrayList<>(); // liczba elementow

        createLists(result, elements, node, 0);

        return countAverage(result, elements);
    }

    static void createLists(List<Double> result, List<Integer> elements, Node node, int level) {
        if (node == null) {
            return;
        }
        if (level == result.size()){
            result.add(0.);
            elements.add(0);
        }

        result.set(level, result.get(level) + node.getNodeNumber());
        elements.set(level, elements.get(level) + 1);

        createLists(result, elements, node.getLeftNode(), level + 1);
        createLists(result, elements, node.getRightNode(), level + 1);
    }

    static List<Double> countAverage(List<Double> result, List<Integer> elements){
        // result: 0, 3, 18, 84
        // elements: 1, 2, 4, 8
        List<Double> average = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            average.add(result.get(i)/elements.get(i));
        }
        return average;
    }
}
