package org.example.recursion;

import java.util.HashMap;
import java.util.Map;

public class ValidSudoku {

    public boolean isValid(char[][] board) {
        return isRowValid(board) && isColumnValid(board) && isBoxValid(board);
    }

    private static boolean isRowValid(char[][] t) {
        for (int row = 0; row < t.length; row++) {
            Map<Character, Integer> occurrences = new HashMap<>();
            for (int cell = 0; cell < t.length; cell++) {
                Character character = t[row][cell];
                if (!character.equals('.')) {
                    if (occurrences.containsKey(character)) {
                        return false;
                    } else {
                        occurrences.put(character, 1);
                    }
                }
            }
        }
        return true;
    }

    private static boolean isColumnValid(char[][] t) {
        for (int col = 0; col < t.length; col++) {
            Map<Character, Integer> occurrences = new HashMap<>();
            for (int cell = 0; cell < t.length; cell++) {
                Character character = t[cell][col];
                if (!character.equals('.')) {
                    if (occurrences.containsKey(character)) {
                        return false;
                    } else {
                        occurrences.put(character, 1);
                    }
                }
            }
        }
        return true;
    }

    private static boolean isBoxValid(char[][] t) {
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                if (!checkBox(t, row, col)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkBox(char[][] t, int rowNo, int colNo) {
        Map<Character, Integer> occurrences = new HashMap<>();
        for (int row = rowNo; row < rowNo + 3; row++) {
            for (int col = colNo; col < colNo + 3; col++) {
                Character character = t[row][col];
                if (!character.equals('.')) {
                    if (occurrences.containsKey(character)) {
                        return false;
                    } else {
                        occurrences.put(character, 1);
                    }
                }
            }
        }
        return true;
    }
}