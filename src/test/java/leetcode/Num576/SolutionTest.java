package leetcode.Num576;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void test1() {
        String s1 = "ab";
        String s2 = "eidbaooo";
        final boolean resultExpected = true;
        boolean resultActual = new Solution().checkInclusion(s1, s2);
        assertEquals(resultExpected, resultActual);
    }

    @Test
    public void test2() {
        String s1 = "ab";
        String s2 = "eidboaoo";
        final boolean resultExpected = false;
        boolean resultActual = new Solution().checkInclusion(s1, s2);
        assertEquals(resultExpected, resultActual);
    }

    @Test
    public void test3() {
        String s1 = "adc";
        String s2 = "dcda";
        final boolean resultExpected = true;
        boolean resultActual = new Solution().checkInclusion(s1, s2);
        assertEquals(resultExpected, resultActual);
    }
}