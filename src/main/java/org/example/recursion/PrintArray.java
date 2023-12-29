package org.example.recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintArray {

//    Wypisz na konsolę wszystkie elementy z tablicy intów o długości 50 o losowych wartościach.

    public static void main(String[] args) {
        print(new int[]{2,6,4,87, 746, 46}, 0);
    }

    static void print(int[] array, int index) {
        int length = array.length;
        if (index == length) {
            return;
        }
        System.out.println(array[index]);
        print(array, index + 1);
    }

}
