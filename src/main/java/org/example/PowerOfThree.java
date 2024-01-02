package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PowerOfThree {
    public boolean isPowerRecursive(int number) {
        if (number == 1) {
            return true;
        }
        if (number < 3 || number % 3 != 0) {
            return false;
        }
        return isPowerRecursive(number / 3);
    }

    public boolean isPower(int number) {
        int[] powers = new int[100];
        for (int i = 0; i < powers.length; i++) {  //O(n)
            powers[i] = (int) Math.pow(3, i);
        }

        List<Integer> list = Arrays.stream(powers)
                .boxed()
                .collect(Collectors.toList());

        return list.contains(number);
    }
}
