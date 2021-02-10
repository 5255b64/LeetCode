package jzoffer.num45;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void test1() {
        int[] input = {10, 2};
        String resultExcepted = "102";
        String resultActual = new Solution().minNumber(input);
        assertEquals(resultExcepted, resultActual);
    }

    @Test
    public void test2() {
        int[] input = {3, 30, 34, 5, 9};
        String resultExcepted = "3033459";
        String resultActual = new Solution().minNumber(input);
        assertEquals(resultExcepted, resultActual);
    }

}