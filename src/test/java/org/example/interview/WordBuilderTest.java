package org.example.interview;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class WordBuilderTest {

    private WordBuilder wb = new WordBuilder();

    @ParameterizedTest
    @MethodSource("provideTestData")
    void canBeBuild(String s, String[] words, boolean expected) {
        boolean result = wb.canBeBuild(s, words);
        assertEquals(expected, result);

    }

    static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of("smog", new String[]{"smoke", "letter", "fog"}, true),
                Arguments.of("clock", new String[]{"smoke", "letter", "clo", "fog", "k"}, false),
                Arguments.of("clock", new String[]{"smoke", "letter", "clo", "fog", "cccck"}, true),
                Arguments.of("snow", new String[]{""}, false),
                Arguments.of("snow", new String[0], false)
        );
    }

}