package org.example.recursion.tree;


import java.util.ArrayList;
import java.util.List;

import static org.example.recursion.tree.TreeHelper.tree;

public class TreeHeight {

    public static void main(String[] args) {
//        System.out.println(height(tree()));
        System.out.println(average(tree()));
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
