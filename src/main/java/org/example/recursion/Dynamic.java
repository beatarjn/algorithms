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

    public int findMinMemo(int[] board, int n) {

        int[] result = new int[n];
        result[0] = board[0];
        result[1] = board[1];
        for (int i = 2; i < result.length; i++) {
            result[i] = -1;
        }
        return memo(board, n, result);
    }

    private int memo(int[] board, int n, int[] result) {
        int second;

        if (n == 0) {
            return result[n];
        }
        if (n != 1) {
            int val;
            if (result[n - 2] != -1) {
                val = result[n - 2];
            } else {
                val = memo(board, n - 2, result);
            }
            second = val + board[n];
        } else {
            second = Integer.MAX_VALUE;
        }
        int first;
        int val1;
        if (result[n - 1] != -1) {
            val1 = result[n - 1];
        } else {
            val1 = memo(board, n - 1, result);
        }
        first = val1 + board[n];

        result[n] = Math.min(first, second);

        return Math.min(first, second);
    }
}