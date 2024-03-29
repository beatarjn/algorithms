package recursion.tree;

import exercises.recursion.tree.Sudoku;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SudokuTest {

    private Sudoku sudoku = new Sudoku();
    private static char[][] t = {
            {'5', '3', '0', '0', '7', '0', '0', '0', '0'},
            {'6', '0', '0', '1', '9', '5', '0', '0', '0'},
            {'0', '9', '8', '0', '0', '0', '0', '6', '0'},
            {'8', '0', '0', '0', '6', '0', '0', '0', '3'},
            {'4', '0', '0', '8', '0', '3', '0', '0', '1'},
            {'7', '0', '0', '0', '2', '0', '0', '0', '6'},
            {'0', '6', '0', '0', '0', '0', '2', '8', '0'},
            {'0', '0', '0', '4', '1', '9', '0', '0', '5'},
            {'0', '0', '0', '0', '8', '0', '0', '7', '9'}};

    private static char[][] t1 = {
            {'0', '8', '7', '6', '5', '4', '3', '2', '1'},
            {'2', '0', '0', '0', '0', '0', '0', '0', '0'},
            {'3', '0', '0', '0', '0', '0', '0', '0', '0'},
            {'4', '0', '0', '0', '0', '0', '0', '0', '0'},
            {'5', '0', '0', '0', '0', '0', '0', '0', '0'},
            {'6', '0', '0', '0', '0', '0', '0', '0', '0'},
            {'7', '0', '0', '0', '0', '0', '0', '0', '0'},
            {'8', '0', '0', '0', '0', '0', '0', '0', '0'},
            {'9', '0', '0', '0', '0', '0', '0', '0', '0'}};

    private static char[][] t2 = {
            {'5', '3', '0', '0', '7', '0', '0', '0', '0'},
            {'6', '0', '0', '1', '9', '5', '0', '0', '0'},
            {'0', '9', '8', '0', '0', '0', '0', '6', '0'},
            {'8', '0', '0', '0', '6', '0', '0', '0', '3'},
            {'4', '0', '0', '8', '0', '3', '0', '0', '1'},
            {'7', '0', '0', '0', '2', '0', '0', '0', '6'},
            {'0', '6', '0', '0', '0', '0', '2', '8', '0'},
            {'0', '0', '0', '4', '1', '9', '0', '0', '5'},
            {'0', '0', '0', '0', '8', '0', '0', '7', '9'}};

    private static char[][] t3 = {
            {'0', '0', '0', '0', '5', '0', '0', '1', '0'},
            {'0', '4', '0', '3', '0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0', '3', '0', '0', '1'},
            {'8', '0', '0', '0', '0', '0', '0', '2', '0'},
            {'0', '0', '2', '0', '7', '0', '0', '0', '0'},
            {'0', '1', '5', '0', '0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0', '2', '0', '0', '0'},
            {'0', '2', '0', '9', '0', '0', '0', '0', '0'},
            {'0', '0', '4', '0', '0', '0', '0', '0', '0'}};

    private static char[][] t4 = {
            {'8', '3', '0', '0', '7', '0', '0', '0', '0'},
            {'6', '0', '0', '1', '9', '5', '0', '0', '0'},
            {'0', '9', '8', '0', '0', '0', '0', '6', '0'},
            {'8', '0', '0', '0', '6', '0', '0', '0', '3'},
            {'4', '0', '0', '8', '0', '3', '0', '0', '1'},
            {'7', '0', '0', '0', '2', '0', '0', '0', '6'},
            {'0', '6', '0', '0', '0', '0', '2', '8', '0'},
            {'0', '0', '0', '4', '1', '9', '0', '0', '5'},
            {'0', '0', '0', '0', '8', '0', '0', '7', '9'}};

    private static char[][] t5 = {
            {'1', '2', '3', '4', '5', '6', '7', '8', '9'},
            {'0', '0', '0', '0', '0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0', '0', '0', '0', '0'}};

    @ParameterizedTest
    @MethodSource("provideTestData")
    void test_traverse(char[][] board, boolean expected) {
        boolean result = sudoku.solve(board);
        assertThat(result).isEqualTo(expected);

    }

    static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(t, true)
//                Arguments.of(t1, false),
//                Arguments.of(t2, true),
////                Arguments.of(t3, true),
//                Arguments.of(t4, false),
//                Arguments.of(t5, true)
        );
    }

    @Test
    public void shouldReturnTrueMy() {
        //given
        char[][] t = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};


        //when
        sudoku.solve(t);

        //then
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Assertions.assertTrue(t[i][j] != '0' && t[i][j] != '.' );
                System.out.print("[ " + t[i][j] + " ]");
            }
            System.out.println();
        }
    }

    @Test
    public void shouldReturnTrueAgain() {
        //given
        char[][] t = {
                {'.','.','9','7','4','8','.','.','.'},
                {'7','.','.','.','.','.','.','.', '.'},
                {'.','2','.','1','.','9','.','.','.'},
                {'.','.','7','.','.','.','2','4','.'},
                {'.','6','4','.','1','.','5','9','.'},
                {'.','9','8','.','.','.','3','.','.'},
                {'.','.','.','8','.','3','.','2','.'},
                {'.','.','.','.','.','.','.','.','6'},
                {'.','.','.','2','7','5','9','.','.'}};

        //when
        sudoku.solve(t);

        //then
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Assertions.assertTrue(t[i][j] != '0' && t[i][j] != '.' );
                System.out.print("[ " + t[i][j] + " ]");
            }
            System.out.println();
        }
    }


    @Test
    public void shouldReturnTruDFS() {
        //given
        char[][] t = {
                {'.','.','9','7','4','8','.','.','.'},
                {'7','.','.','.','.','.','.','.', '.'},
                {'.','2','.','1','.','9','.','.','.'},
                {'.','.','7','.','.','.','2','4','.'},
                {'.','6','4','.','1','.','5','9','.'},
                {'.','9','8','.','.','.','3','.','.'},
                {'.','.','.','8','.','3','.','2','.'},
                {'.','.','.','.','.','.','.','.','6'},
                {'.','.','.','2','7','5','9','.','.'}};

        //when
        sudoku.solve(t);

        //then
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Assertions.assertTrue(t[i][j] != '0' && t[i][j] != '.' );
                System.out.print("[ " + t[i][j] + " ]");
            }
            System.out.println();
        }
    }


}
