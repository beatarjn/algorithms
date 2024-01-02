package recursion.tree;

import org.example.recursion.tree.BFS;
import org.example.recursion.tree.Node;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static recursion.tree.TreeTestHelper.*;

class BFSTest {

    private BFS bfs = new BFS();

    @ParameterizedTest
    @MethodSource("provideTestData")
    void test_traverse(Node node, List<Integer> expected) {
        List<Integer> traverse = bfs.traverse(node);
        assertThat(traverse)
                .isEqualTo(expected)
                .isNotEqualTo(Arrays.asList(3, 5, 78, 7));
    }

    static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(tree(), Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14)),
                Arguments.of(tree1(), Arrays.asList(0, 2, 5, 7, 3, 11, 14, 8, 6, 15)),
                Arguments.of(tree2(), Arrays.asList(0, 2, 5, 3, 11, 14, 15, 34, 2, 1))
        );
    }

    @Test
    public void test_traverseEmpty(){
        List<Integer> traverse = bfs.traverse(null);
        assertThat(traverse).isEmpty();
    }

}