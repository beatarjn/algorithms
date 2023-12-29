package org.example.recursion.tree;

public class Node {


    private final Node leftNode;
    private final Node rightNode;
    private final int nodeNumber;

    public Node(Node leftNode, Node rightNode, int nodeNumber) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.nodeNumber = nodeNumber;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public int getNodeNumber() {
        return nodeNumber;
    }
}

