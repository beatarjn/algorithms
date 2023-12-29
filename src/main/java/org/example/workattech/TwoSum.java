package org.example.workattech;

import java.util.*;

public class TwoSum {

//    Given an array A and an integer target, find the indices of the two numbers
//    in the array whose sum is equal to the given target.
//    A: [1, 3, 3, 4]
//    target: 5
//    Answer: [0, 3]
    // 4,2,2,1

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(twoSumBrute(new int[]{1, 3, 3, 4}, 5)));
//        System.out.println(Arrays.toString(twoSum(new int[]{1, 3, 3, 4}, 5)));
        System.out.println(Arrays.toString(twoSumMap(new int[]{1, 3, 3, 4}, 5)));

    }

    static int[] twoSumBrute(int[] array, int target) { //O(n^2)
        int[] result = new int[2];
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] == target - array[i]) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    static int[] twoSum(int[] array, int target) { //O(n)
        int[] result = new int[2];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if (list.contains(array[i])) {
                result[0] = list.indexOf(array[i]);
                result[1] = i;
            } else {
                list.add(target - array[i]);
            }
        }
        return result;
    }

    static int[] twoSumMap(int[] array, int target) { //O(n)
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int key = target - array[i];
            if (map.containsKey(key)) {
                return new int[]{i, map.get(key)};
            } else {
                map.put(array[i], i);
            }
        }
        return new int[]{};
    }
}
