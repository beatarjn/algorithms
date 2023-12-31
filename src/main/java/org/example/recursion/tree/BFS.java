package org.example.recursion.tree;

import java.util.*;

public class BFS {

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

    public List<Integer> traverse(Node node){
        List<Integer> list = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();

        if (node == null) {
            return Collections.emptyList();
        }
        queue.add(node);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            list.add(poll.getNodeNumber());
            if (poll.getLeftNode() != null) {
                queue.add(poll.getLeftNode());
            }
            if (poll.getRightNode() != null) {
                queue.add(poll.getRightNode());
            }
        }
        return list;
    }

}