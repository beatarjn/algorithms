package org.example.recursion.tree;

import java.util.List;

public class DFS {
    public List<Integer> traverse(Node node, List<Integer> list) {
        if (node != null) {
            list.add(node.getNodeNumber());
            traverse(node.getLeftNode(), list);
            traverse(node.getRightNode(), list);
        }
        return list;
    }

}
