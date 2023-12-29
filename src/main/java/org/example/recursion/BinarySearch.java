package org.example.recursion;

import java.util.stream.IntStream;

public class BinarySearch {
//    Zaimplementuj wyszukiwanie binarne na posortowanej tablicy intów o długości 100.


    public boolean search(int[] array, int key) {
        int length = array.length;
        int mid = getMid(length);

        if (length == 0 || length == 1 && array[0] != key) {
            return false;
        }
        if ((length == 1 && array[0] == key) || (length > 1 && key == array[mid])) {
            return true;
        }

        if (key < array[mid]) {
            int[] left = generateSubarray(array, 0, mid);
            return search(left, key);
        } else {
            int[] subArr = generateSubarray(array, mid, array.length);
            return search(subArr, key);
        }
    }

    private static int[] generateSubarray(int[] array, int start, int end) {
        return IntStream.range(start, end)
                .map(i -> array[i])
                .toArray();
    }

    private static int getMid(int length) {
        int mid;
        if (length % 2 == 0) {
            mid = length / 2;
        } else {
            mid = 1 + length / 2;
        }
        return mid;
    }
}
