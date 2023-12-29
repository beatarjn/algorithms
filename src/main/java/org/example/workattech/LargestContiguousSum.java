package org.example.workattech;

public class LargestContiguousSum {

    public static void main(String[] args) {
        int[] ints = {4, -6, 2, 5};

    }

    static int largestContiguousSum(int[] arr) {
        int max = Integer.MIN_VALUE;
        int maxEnd = 0;

        for (int i = 0; i < arr.length; i++) {
            maxEnd = maxEnd + arr[i];
            if (max < maxEnd) {
                max = maxEnd;
            }
            if (maxEnd < 0) {
                maxEnd = 0;
            }
        }
        return max;
    }

}
