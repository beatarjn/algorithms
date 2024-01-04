package org.example.recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DynamicTest {

    private Dynamic dynamic = new Dynamic();

    @Test
    public void shouldReturn15Recursive() {
        //given
        int[] stairs = new int[]{10, 15, 20};

        //when
        int result = dynamic.findMinRecursive(stairs, stairs.length-1);

        //then
        Assertions.assertEquals(30, result);
    }

    @Test
    public void shouldReturn6Recursive() {
        //given
        int[] stairs = new int[]{1,100,1,1,1,100,1,1,100,1};

        //when
        int result = dynamic.findMinRecursive(stairs, stairs.length-1);

        //then
        Assertions.assertEquals(6, result);
    }

    @Test
    public void shouldReturn16Recursive() {
        //given
        int[] stairs = new int[]{1,4,5,2,3,9};

        //when
        int result = dynamic.findMinRecursive(stairs, stairs.length-1);

        //then
        Assertions.assertEquals(16, result);
    }



}