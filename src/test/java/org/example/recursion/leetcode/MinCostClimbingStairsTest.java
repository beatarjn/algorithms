package org.example.recursion.leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MinCostClimbingStairsTest {

    private MinCostClimbingStairs min = new MinCostClimbingStairs();

    @ParameterizedTest
    @MethodSource("provideTestData")
    void minCostClimbingStairsRec(int[] cost, int expected) {
        int result = min.minCostClimbingStairsRec(cost);
        assertEquals(expected, result);

    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void minCostClimbingStairsMemo(int[] cost, int expected) {
        int result = min.minCostClimbingStairsMemo(cost);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void minCostClimbingStairsDp(int[] cost, int expected) {
        int result = min.minCostClimbingStairsDp(cost);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void minCostClimbingStairsDpMap(int[] cost, int expected) {
        int result = min.minCostClimbingStairsDpMap(cost);
        assertEquals(expected, result);
    }

    static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(new int[]{10, 15, 20}, 15),
                Arguments.of(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}, 6)
        );
    }
}