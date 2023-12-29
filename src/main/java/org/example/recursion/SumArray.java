package org.example.recursion;

public class SumArray {
    //    Zsumuj wszystkie elementy tablicy intów o długości 10 o losowych wartościach.
    private static final int SIZE = 10;

    public static void main(String[] args) {
        System.out.println(sum(new int[]{2, 6, 4, 87, 746, 46, 1, 4, 67, 5}, SIZE));
    }

    public static int sum(int[] array, int length) {
        if (length <= 0) {
            return 0;
        }
        return (sum(array, length - 1) + array[length - 1]);
    }


}
