package org.example.recursion;

import java.util.*;
import java.util.stream.IntStream;

public class ContactList {

    public List<String> answers(int[][] persons, int[][] info, int m, int z) {
        List<String> result = new ArrayList<>();
        Map<Integer, Integer> pairs = new LinkedHashMap<>();

        for (int row = 0; row < m; row++) {
            pairs.put(persons[row][0], persons[row][1]);
        }

        IntStream.range(0, z).forEachOrdered(row -> {
            int key = info[row][0];
            result.add(pairs.containsKey(key) && pairs.get(key).equals(info[row][1]) ? "TAK" : "NIE");
        });
        return result;
    }
}
