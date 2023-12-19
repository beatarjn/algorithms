package org.example;

import java.util.Arrays;

public class MergeArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 4, 7, 9};
        int[] nums2 = {1, 3, 5, 6, 8, 12};

        int[] merge = merge(nums1, nums2);
        int[] mergeAndSort = mergeAndSort(nums1, nums2);

        System.out.println(Arrays.toString(merge));
        System.out.println(Arrays.toString(mergeAndSort));
    }


    public static int[] merge(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];
        int indexResult = 0;
        int index2 = 0;
        int index1 = 0;

        while (index1 < array1.length && index2 < array2.length) { // O(n)
            if (array1[index1] == array2[index2]) {
                result[indexResult] = array1[index1];
                indexResult++;
                index1++;
                result[indexResult] = array2[index2];
                indexResult++;
                index2++;
            } else if (array1[index1] > array2[index2]) {
                result[indexResult] = array2[index2];
                indexResult++;
                index2++;
            } else {
                result[indexResult] = array1[index1];
                indexResult++;
                index1++;
            }
        }

        while (index1 < array1.length) { // O(m)
            result[indexResult] = array1[index1];
            indexResult++;
            index1++;
        }

        while (index2 < array2.length) { // O(o)
            result[indexResult] = array2[index2];
            indexResult++;
            index2++;
        }

        return result; // O(n+m+o)
    }

    public static int[] mergeAndSort(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];

        for (int i = 0; i < array1.length; i++) {  // O(n)
            result[i] = array1[i];
        }

        for (int i = 0; i < array2.length; i++) { //O(m)
            int length1 = array1.length;
            result[length1 + i] = array2[i];
        }

        Arrays.sort(result); // O(o log(o))
        return result;  // zlożoność: O(n+m) + O(o log(o))
    }

}
