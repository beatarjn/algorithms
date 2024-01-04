package org.example.recursion;

public class Dynamic {

    public int findMinRecursive(int[] board, int n) {
        int second;
        if (n == 0) {
            return board[n];
        }
        if (n != 1) {
            second = findMinRecursive(board, n - 2) + board[n];
        } else {
            second = Integer.MAX_VALUE;
        }
        int first = findMinRecursive(board, n - 1) + board[n];
        return Math.min(first, second);
    }
}