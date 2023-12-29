package org.example.workattech;

import java.util.Arrays;

public class PascalTriangle {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(pascalTriangleRow(8)));
    }

    static int[] pascalTriangleRow(int rowNo) { // O(2^n) ?

        int[] current = new int[rowNo];
        if (rowNo == 0) {
            return current;
        }
        current[0] = 1;
        int[] prev = pascalTriangleRow(rowNo - 1);

        for (int i = 1; i <= prev.length; i++) {
            int num = prev[i - 1] + prev[i];
            current[i] = num;
        }
        current[current.length - 1] = 1;

        return current;
    }

}

