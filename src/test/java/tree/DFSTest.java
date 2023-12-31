package tree;

import org.example.recursion.tree.DFS;
import org.example.recursion.tree.Node;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static tree.TreeTestHelper.*;

class DFSTest {

    private DFS dfs = new DFS();

    @ParameterizedTest
    @MethodSource("provideTestData")
    void test_traverse(Node node, List<Integer> expected) {
        List<Integer> traverse = dfs.traverse(node, new ArrayList<>());
        assertThat(traverse)
                .isEqualTo(expected)
                .isNotEqualTo(Arrays.asList(3, 5, 78, 7));
    }

    static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(tree(), Arrays.asList(0, 1, 3, 7, 8, 4, 9, 10, 2, 5, 11, 12, 6, 13, 14)),
                Arguments.of(tree1(), Arrays.asList(0, 2, 7, 8, 6, 3, 15, 5, 11, 14)),
                Arguments.of(tree2(), Arrays.asList(0,2,3,15,5,11,34,14,2,1))
        );
    }

    @Test
    public void test_traverseEmpty(){
        List<Integer> traverse = dfs.traverse(null, new ArrayList<>());
        assertThat(traverse).isEmpty();
    }

}