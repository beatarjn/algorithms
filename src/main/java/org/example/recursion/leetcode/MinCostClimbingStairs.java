package org.example.recursion.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinCostClimbingStairs {

    public int minCostClimbingStairsRec(int[] cost) {
        int length = cost.length;
        int start0 = getCost(cost, length - 1);
        int start1 = getCost(cost, length - 2);

        return Math.min(start0, start1);
    }

    private static int getCost(int[] cost, int n) {
        if (n == 1 || n == 0) {
            return cost[n];
        }
        if (n < 0) {
            return 0;
        }
        int sec = getCost(cost, n - 2) + cost[n];
        int first = getCost(cost, n - 1) + cost[n];
        return Math.min(first, sec);
    }


    public int minCostClimbingStairsMemo(int[] cost) {
        int n = cost.length;
        int[] temp = new int[n];
        int start0 = memo(cost, n - 1, temp);
        int start1 = memo(cost, n - 2, temp);
        return Math.min(start0, start1);
    }

    private int memo(int[] cost, int n, int[] temp) {
        if (n < 0) {
            return 0;
        }
        if (n == 1 || n == 0) {
            return cost[n];
        }

        if (temp[n] != 0) {
            return temp[n];
        }

        temp[n] = Math.min(memo(cost, n - 1, temp), memo(cost, n - 2, temp)) + cost[n];
        return temp[n];
    }

    public int minCostClimbingStairsDp(int[] cost) {
        int start0 = min(cost);
        int start1 = min(cost);
        return Math.min(start0, start1);
    }

    private int min(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (i < 2) {
                dp[i] = cost[i];
            } else {
                dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
            }
        }
        return Math.min(dp[n - 1], dp[n - 2]);
    }

    public int minCostClimbingStairsDpMap(int[] cost) {
        int start0 = minMap(cost);
        int start1 = minMap(cost);
        return Math.min(start0, start1);
    }

    private int minMap(int[] cost) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = cost.length;
        for (int i = 0; i < n; i++) {
            if (i < 2) {
                map.put(i, cost[i]);
            } else {
                map.put(i, cost[i] + Math.min(map.get(i - 1), map.get(i - 2)));
            }
        }
        return Math.min(map.get(n - 1), map.get(n - 2));
    }
}
