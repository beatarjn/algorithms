package recursion;

import org.example.recursion.BinarySearch;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class BinarySearchTest {

    private BinarySearch bs = new BinarySearch();

    @ParameterizedTest
    @MethodSource("provideTestData_True")
    void testBinarySearch_found(int[] array, int number) {
        assertTrue(bs.search(array, number));
    }

    static Stream<Arguments> provideTestData_True() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 5, 6, 8, 9, 12, 14, 16}, 12),
                Arguments.of(new int[]{1, 2, 3, 5, 6, 8, 9, 12, 14, 16}, 1),
                Arguments.of(new int[]{1, 2, 3, 5, 6, 8, 9, 12, 14, 16}, 5),
                Arguments.of(new int[]{1, 2, 3, 5, 6, 8, 9, 12, 14, 16}, 8),
                Arguments.of(new int[]{1, 2, 3, 5, 6, 8, 9, 12, 14, 16}, 16)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestData_False")
    void testBinarySearch_NotFound(int[] array, int number) {
        assertFalse(bs.search(array, number));
    }

    static Stream<Arguments> provideTestData_False() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 5, 6, 8, 9, 12, 14, 16}, 4),
                Arguments.of(new int[]{1, 2, 3, 5, 6, 8, 9, 12, 14, 16}, -1),
                Arguments.of(new int[]{1, 2, 3, 5, 6, 8, 9, 12, 14, 16}, 7),
                Arguments.of(new int[]{1, 2, 3, 5, 6, 8, 9, 12, 14, 16}, 156),
                Arguments.of(new int[]{1, 2, 3, 5, 6, 8, 9, 12, 14, 16}, 0)
        );
    }
}
