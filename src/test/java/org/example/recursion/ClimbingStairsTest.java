package org.example.recursion;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClimbingStairsTest {

    private ClimbingStairs cs = new ClimbingStairs();

    @ParameterizedTest
    @MethodSource("provideTestData")
    void climbStairsRec(int n, int expected) {
        int result = cs.climbStairsDp(n);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void climbStairsMemo(int n, int expected) {
        int result = cs.climbStairsDp(n);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void climbStairsDp(int n, int expected) {
        int result = cs.climbStairsDp(n);
        assertEquals(expected, result);
    }

    static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(2, 2),
                Arguments.of(3, 3),
                Arguments.of(4, 5),
                Arguments.of(5, 8),
                Arguments.of(6, 13),
                Arguments.of(45, 1836311903)
        );
    }
}