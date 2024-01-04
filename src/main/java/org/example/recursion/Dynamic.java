package org.example.recursion;

import static java.lang.Math.min;

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
        return min(first, second);
    }

    public int findMinMemo(int[] board, int n) {

        int[] result = new int[n + 1];
        result[0] = board[0];
        for (int i = 1; i < result.length; i++) {
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

        result[n] = min(first, second);

        return min(first, second);
    }

    public int findMinDyn(int[] board, int n) {
        int[] dp = new int[n + 1];
        dp[0] = board[0];

        for (int i = 1; i < dp.length; i++) {
            dp[i] = -1;
        }
        int first;
        int sec;

        for (int i = 1; i < dp.length; i++) {
            if (i == 1) {
                sec = Integer.MAX_VALUE;
            } else {
                sec = dp[i - 2];
            }
            first = dp[i - 1];
            int val = min(first, sec);
            dp[i] = val + board[i];
        }
        return dp[dp.length - 1];
    }

    public static int findMinDp(int[] board, int n) {
        int[] result = new int[n + 1];
        result[0] = board[0];
        for (int i = 1; i < n + 1; i++) {
            result[i] = -1;
        }

        for (int i = 1; i < result.length; i++) {
            int left = board[i] + result[i - 1];
            int right = board[i] + (i - 2 < 0 ? result[i - 1] : result[i - 2]);

            int min = min(left, right);
            result[i] = min;
        }
        return result[result.length - 1];
    }
}