package org.example.workattech;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortedArraysIntersection {
//    Given 2 sorted arrays, return the intersection of both the arrays.
//    The intersection of 2 arrays means all the elements which are present in both.
//    Note: The resultant array should also be sorted.

//    Array 1: [1, 3, 4, 5, 5, 6, 6, 7]
//    Array 2: [2, 5, 6, 6, 7, 8]
//    Intersection: [5, 6, 6, 7]

    public static void main(String[] args) {
//        System.out.println(intersection(new int[]{1, 3, 4, 5, 5, 6, 6, 7}, new int[]{2, 5, 6, 6, 7, 8}));
        System.out.println(intersection2(new int[]{1, 3, 4, 5, 5, 6, 6, 7}, new int[]{2, 5, 6, 6, 7, 8}));

    }

    static List<Integer> intersection(int[] arr1, int[] arr2) { //O(n+m)
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            Integer value = 1;
            int key = arr1[i];
            if (map.containsKey(key)) {
                value = map.get(key);
                map.put(key, value + 1);
            } else {
                map.put(key, value);
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            int key = arr2[i];
            if (map.containsKey(key)) {
                list.add(key);
                Integer value = map.get(key);
                map.put(key, value - 1);
            }
        }
        return list;
    }

    static List<Integer> intersection2(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else {
                list.add(arr1[i]);
                i++;
                j++;
            }
        }
        return list;
    }


}