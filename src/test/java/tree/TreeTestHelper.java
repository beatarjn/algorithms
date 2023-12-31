package tree;

import org.example.recursion.tree.Node;

public class TreeTestHelper {
    public static final int ROOT_INDEX = 0;

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

    public static Node tree1() {
        /**
         *                  0
         *               /     \
         *             /        \
         *           /           \
         *         /              \
         *       2                5
         *     /   \            /  \
         *    7     3         11      14
         *   / \   /
         *  8  6  15
         *
         *
         **/


        var node9 = new Node(null, null, 15);
        var node8 = new Node(null, null, 6);
        var node7 = new Node(null, null, 8);
        var node6 = new Node(null, null, 14);
        var node5 = new Node(null, null, 11);
        var node4 = new Node(node9, null, 3);
        var node3 = new Node(node7, node8, 7);
        var node2 = new Node(node5, node6, 5);
        var node1 = new Node(node3, node4, 2);
        var node0 = new Node(node1, node2, ROOT_INDEX);
        return node0;
    }

    public static Node tree2() {
        /**
         *                  0
         *               /     \
         *             /        \
         *           /           \
         *         /              \
         *       2                5
         *       \            /  \
         *        3         11      14
         *      /             \     / \
         *      15             34  2   1
         *
         *
         **/


        var node9 = new Node(null, null, 1);
        var node8 = new Node(null, null, 2);
        var node7 = new Node(null, null, 34);
        var node6 = new Node(null, null, 15);
        var node5 = new Node(node8, node9, 14);
        var node4 = new Node(null, node7, 11);
        var node3 = new Node(node6, null, 3);
        var node2 = new Node(node4, node5, 5);
        var node1 = new Node(null, node3, 2);
        var node0 = new Node(node1, node2, ROOT_INDEX);
        return node0;
    }
}
