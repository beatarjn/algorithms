package org.example.recursion.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class ClimbingStairs {

//    You are climbing a staircase. It takes n steps to reach the top.
//
//    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

//    Input: n = 2
//    Output: 2
//    Explanation: There are two ways to climb to the top.
//      1. 1 step + 1 step
//      2. 2 steps

//    Input: n = 3
//    Output: 3
//    Explanation: There are three ways to climb to the top.
//      1. 1 step + 1 step + 1 step
//      2. 1 step + 2 steps
//      3. 2 steps + 1 step


    public int climbStairsRec(int n) {
        if (n <= 1) {
            return 1;
        }
        return climbStairsRec(n - 1) + climbStairsRec(n - 2);
    }

    public int climbStairsMemo(int n) {
        int[] temp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            temp[i] = -1;
        }
        return memo(temp, n);
    }

    private int memo(int[] temp, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (temp[n] != -1) {
            return temp[n];
        }
        temp[n] = memo(temp, n - 1) + memo(temp, n - 2);
        return temp[n];
    }

    public int climbStairsDp(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i == 0 || i == 1) {
                dp[i] = 1;
            } else {
                dp[i] = -1;
            }
        }
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairsDpMap(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        map.put(1, 1);
        IntStream.rangeClosed(2, n)
                .forEach(i -> map.put(i, map.get(i - 1) + map.get(i - 2)));
        return map.get(n);
    }

}