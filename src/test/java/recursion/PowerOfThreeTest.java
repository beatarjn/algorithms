package recursion;

import org.example.recursion.PowerOfThree;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PowerOfThreeTest {

    private PowerOfThree pot = new PowerOfThree();

    @ParameterizedTest
    @MethodSource("provideTestData")
    void test_isPowerOfThree(int number, boolean expected) {
        boolean result = pot.isPowerRecursive(number);
        assertThat(result).isEqualTo(expected);

    }

    static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(27, true),
                Arguments.of(-1, false),
                Arguments.of(45, false),
                Arguments.of(19684, false),
                Arguments.of(3, true),
                Arguments.of(9, true),
                Arguments.of(1, true)
        );
    }
}
