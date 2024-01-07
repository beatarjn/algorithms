package org.example.recursion.leetcode;

public class JumpGameIV {

    public int maxResultRec(int[] nums, int k) {
        int n = nums.length;
        return getMaxK(n - 1, nums, k);
    }

    private int getMaxK(int n, int[] nums, int k) {
        if (n == 0) {
            return nums[n];
        }
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= k; i++) {
            int jump = Integer.MIN_VALUE;
            if (n - i >= 0) {
                jump = nums[n] + getMaxK(n - i, nums, k);
            }
            max = Math.max(max, jump);
        }
        return max;
    }

    public int maxResultMemo(int[] nums, int k) {
        int n = nums.length;
        return getMaxMemo(n - 1, nums, k);
    }

    private int getMaxMemo(int n, int[] nums, int k) {
        int[] temp = new int[n + 1];

        if (n == 0) {
            return nums[n];
        }

        if (temp[n] != 0) {
            return temp[n];
        }
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= k; i++) {
            int jump = Integer.MIN_VALUE;
            if (n - i >= 0) {
                jump = nums[n] + getMaxMemo(n - i, nums, k);
            }
            max = Math.max(max, jump);
            temp[n] = max;
        }
        return temp[n];
    }

    public int maxResultDp(int[] nums, int k) {
        int n = nums.length;
        int[] temp = new int[n + 1];
        temp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j <= k; j++) {
                int jump;
                if (i - j >= 0) {
                    jump = temp[i - j] + nums[i];
                    max = Math.max(max, jump);
                }
            }
            temp[i] = max;
        }
        return temp[n - 1];
    }
}