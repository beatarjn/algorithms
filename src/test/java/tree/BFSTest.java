package tree;

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

public class BFSTest {
    public static final int ROOT_INDEX = 0;

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

    public static Node tree() {
        var node14 = new Node(null, null, 14);
        var node13 = new Node(null, null, 13);
        var node12 = new Node(null, null, 12);
        var node11 = new Node(null, null, 11);
        var node10 = new Node(null, null, 10);
        var node9 = new Node(null, null, 9);
        var node8 = new Node(null, null, 8);
        var node7 = new Node(null, null, 7);
        var node6 = new Node(node13, node14, 6);
        var node5 = new Node(node11, node12, 5);
        var node4 = new Node(node9, node10, 4);
        var node3 = new Node(node7, node8, 3);
        var node2 = new Node(node5, node6, 2);
        var node1 = new Node(node3, node4, 1);
        var node0 = new Node(node1, node2, ROOT_INDEX);
        return node0;
    }

    public static Node tree1() {
        /**
         *                  0
         *               /     \
         *             /        \
         *           /           \
         *         /              \
         *       2                5
         *     /   \            /  \
         *    7     3         11      14
         *   / \   /
         *  8  6  15
         *
         *
         **/
        var node9 = new Node(null, null, 15);
        var node8 = new Node(null, null, 6);
        var node7 = new Node(null, null, 8);
        var node6 = new Node(null, null, 14);
        var node5 = new Node(null, null, 11);
        var node4 = new Node(node9, null, 3);
        var node3 = new Node(node7, node8, 7);
        var node2 = new Node(node5, node6, 5);
        var node1 = new Node(node3, node4, 2);
        var node0 = new Node(node1, node2, ROOT_INDEX);
        return node0;
    }

    public static Node tree2() {
        /**
         *                  0
         *               /     \
         *             /        \
         *           /           \
         *         /              \
         *       2                5
         *       \            /  \
         *        3         11      14
         *      /             \     / \
         *      15             34  2   1
         *
         *
         **/

        var node9 = new Node(null, null, 1);
        var node8 = new Node(null, null, 2);
        var node7 = new Node(null, null, 34);
        var node6 = new Node(null, null, 15);
        var node5 = new Node(node8, node9, 14);
        var node4 = new Node(null, node7, 11);
        var node3 = new Node(node6, null, 3);
        var node2 = new Node(node4, node5, 5);
        var node1 = new Node(null, node3, 2);
        var node0 = new Node(node1, node2, ROOT_INDEX);
        return node0;
    }
}
