package org.example.workattech;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UniqueElementsInSortedArray {
//    Given a sorted array A, find the size of array A after removing the duplicate elements.
//
//    Examples:
//    A: [1 2 3 3 3 4 5 5]
//    size = 5

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,2,3,3,3,4,5,5}));
    }

    static int removeDuplicates(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        return set.size();
    }
}
