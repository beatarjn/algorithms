package recursion;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.example.recursion.Factorial.factorial;
import static org.junit.Assert.assertEquals;

public class FactorialTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    public void testFactorial(int number, int expected) {
        assertEquals(factorial(number), expected);
    }

    static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(5, 120),
                Arguments.of(0, 1),
                Arguments.of(1, 1),
                Arguments.of(8, 40320),
                Arguments.of(4, 24)
        );
    }
}