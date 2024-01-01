package org.example.recursion.tree;

public class Sudoku {

    private static final int MIN = 1;
    private static final int MAX = 9;
    private static final int SUBSECTION_SIZE = 3;


//    sprawdzenie, czy zadana tablica charów jest poprawna do uzupełnienia sudoku (nie czy dałoby się!).
//    Tj czy da się uzupełnić luki liczbami 1-9 tak by nie powtarzały się w danym wierszu,
//    kolumnie ani w kwadracie 3x3. i czy poprawnie)

    public boolean solve(char[][] t) {

        for (int row = 0; row < t.length; row++) {
//            System.out.println(Arrays.deepToString(t));
            for (int col = 0; col < t.length; col++) {
                if (t[row][col] == '0') {
                    for (int num = MIN; num <= MAX; num++) {
                        if (isValid(t, row, col, Character.forDigit(num, 10))) {
                            t[row][col] = Character.forDigit(num, 10);
                            if (solve(t)) {
                                return true;
                            } else {
                                t[row][col] = '0';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(char[][] t, int row, int col, char character) {
        return checkRow(t, row, character) && checkColumn(t, col, character) && checkBox(t, row, col, character);
    }

    private static boolean checkRow(char[][] t, int row, char character) {
        for (int i = 0; i < t[row].length; i++) {
            if (character == t[row][i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkBox(char[][] t, int row, int col, char character) {
        int boxRowStart = row - row % SUBSECTION_SIZE;
        int boxColStart = col - col % SUBSECTION_SIZE;

        for (int r = boxRowStart;
             r < boxRowStart + SUBSECTION_SIZE; r++) {
            for (int d = boxColStart;
                 d < boxColStart + SUBSECTION_SIZE; d++) {
                if (t[r][d] == character) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkColumn(char[][] t, int col, char character) {
        for (int i = 0; i < t.length; i++) {
            if (character == t[i][col]) {
                return false;
            }
        }
        return true;
    }
}