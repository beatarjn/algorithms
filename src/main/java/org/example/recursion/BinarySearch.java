package org.example.recursion;

public class BinarySearch {
//    Zaimplementuj wyszukiwanie binarne na posortowanej tablicy intów o długości 100.

    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 2, 3, 5, 6, 8, 9, 12, 14, 16}, 16));
    }

    public static boolean search(int[] array, int key) {

        int mid = array.length / 2;
        if (array.length == 0) {
            return false;
        }
        if (key == array[mid]) {
            return true;
        }

        if (key < array[mid]) {
            int[] left = new int[mid];
            System.arraycopy(array, 0, left, 0, mid);
            return search(left, key);
        } else {
            int[] right = new int[mid];
            System.arraycopy(array, mid, right, 0, mid);
            return search(right, key);
        }
    }
}
