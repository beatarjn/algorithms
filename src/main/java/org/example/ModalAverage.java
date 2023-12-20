package org.example;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ModalAverage {
//    wejście: tablica liczb (intów)
//    wyjście: zwróć liczbę, która występuje najczęściej w zadanej tablicy (średnią modalną). Załóż, że taka liczba występuje zawsze.
//    Przykład: tablica = [ 1, 2, 2, 2, 2, 2, 3, 3, 4 ]. Średnia modalna: 2 (występuje najczęściej).
//    Inny przykład: tablica = [1, 3, 3, 3, 2, 2, 2, 4, 4, 4, 4 ]. Średnia modalna: 4 (co prawda 2 występuje 3 razy, 3 występuje 3 razy
//    ale to czwórka występuje jednak cztery razy)

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 2, 2, 3, 3, 4};
        int[] nums2 = {1, 3, 3, 3, 2, 2, 2, 4, 4, 4, 4};
        System.out.println(getModal(nums));
        System.out.println(getModal(nums2));

    }

    public static int getModal(int[] array) { // O(n+m)
        Map<Integer, Integer> map = new HashMap<>(); // O(n)
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                Integer value = map.get(array[i]);
                value++;
                map.put(array[i], value);
            } else {
                map.put(array[i], 0);
            }
        }
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey(); // O(m)
    }


}