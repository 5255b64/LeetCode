package leetcode.Num888;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void test1(){
        int[] a={1,1};
        int[] b={2,2};
        int[] resultExpected={1,2};
        int[] resultActual = new Solution().fairCandySwap(a,b);
        assertArrayEquals(resultExpected,resultActual);
    }

    @Test
    public void test2(){
        int[] a={1,2};
        int[] b={2,3};
        int[] resultExpected={1,2};
        int[] resultActual = new Solution().fairCandySwap(a,b);
        assertArrayEquals(resultExpected,resultActual);
    }

    @Test
    public void test3(){
        int[] a={2};
        int[] b={1,3};
        int[] resultExpected={2,3};
        int[] resultActual = new Solution().fairCandySwap(a,b);
        assertArrayEquals(resultExpected,resultActual);
    }
}