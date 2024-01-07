package org.example.recursion.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class JumpGameIVTest {

    private JumpGameIV game = new JumpGameIV();

    @ParameterizedTest
    @MethodSource("provideTestData")
    void maxResultRec(int[] nums, int k, int expected) {
        int result = game.maxResultRec(nums, k);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void maxResultMemo(int[] nums, int k, int expected) {
        int result = game.maxResultMemo(nums, k);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void maxResultDp(int[] nums, int k, int expected) {
        int result = game.maxResultDp(nums, k);
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(new int[]{1, -1, -2, 4, -7, 3}, 2, 7),
                Arguments.of(new int[]{10, -5, -2, 4, 0, 3}, 3, 17),
                Arguments.of(new int[]{1, -5, -20, 4, -1, 3, -6, -3}, 2, 0)
        );
    }
}