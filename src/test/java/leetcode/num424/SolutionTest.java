package leetcode.num424;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void test1() {
        String s = "ABAB";
        int k = 2;
        int outputExpected = 4;
        int outputActural = new Solution().characterReplacement(s, k);
        assertEquals(outputExpected,outputActural);
    }

    @Test
    public void test2() {
        String s = "AABABBA";
        int k = 1;
        int outputExpected = 4;
        int outputActural = new Solution().characterReplacement(s, k);
        assertEquals(outputExpected,outputActural);
    }

    @Test
    public void test3() {
        String s = "BAAA";
        int k = 0;
        int outputExpected = 3;
        int outputActural = new Solution().characterReplacement(s, k);
        assertEquals(outputExpected,outputActural);
    }

    @Test
    public void test4() {
        String s = "BAAAB";
        int k = 2;
        int outputExpected = 5;
        int outputActural = new Solution().characterReplacement(s, k);
        assertEquals(outputExpected,outputActural);
    }
}