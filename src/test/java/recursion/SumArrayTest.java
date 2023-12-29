package recursion;

import org.example.recursion.SumArray;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static org.example.recursion.SumArray.sum;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class SumArrayTest {
    private static final int SIZE = 10;

    @Test
    public void test_sum(){
        int[] array  = IntStream.generate(new Random()::nextInt).limit(SIZE).toArray();
        int expected = Arrays.stream(array).sum();
        int result = sum(array, SIZE);

        assertEquals(expected, result);
    }


}
