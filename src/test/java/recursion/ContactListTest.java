package recursion;

import org.example.recursion.ContactList;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ContactListTest {

    private static final String TAK = "TAK";
    private static final String NIE = "NIE";


    private ContactList contactList = new ContactList();

    @ParameterizedTest
    @MethodSource("provideTestData")
    void test_AnswersCorrect(int[][] persons, int[][] infos, int m, int z, List<String> expected) {
        List<String> answers = contactList.answers(persons, infos, m, z);

        assertThat(answers)
                .isNotNull()
                .isNotEmpty()
                .hasSize(z)
                .isEqualTo(expected);
    }

    static Stream<Arguments> provideTestData() {

        return Stream.of(
                Arguments.of(new int[][]{{1, 2}, {2, 5}, {3, 4}}, new int[][]{{1, 2}, {1, 3}, {2, 4}, {3, 5}}, 3, 4, Arrays.asList(TAK, NIE, NIE, NIE)),
                Arguments.of(new int[][]{{1, 2}, {3, 4}}, new int[][]{{1, 2}, {1, 3}}, 2, 2, Arrays.asList(TAK, NIE)),
                Arguments.of(new int[][]{{1, 2}, {3, 4}}, new int[][]{{2, 1}, {3, 1}}, 2, 2, Arrays.asList(NIE, NIE))
        );
    }
}
