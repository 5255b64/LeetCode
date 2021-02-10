package leetcode.Num154;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution2Test {
    @Test
    public void test1(){
        Solution2 solution = new Solution2();
        int[] input = {1,3,5};
        int result = 1;
        int output = solution.findMin(input);
        assertEquals(result, output);
    }

    @Test
    public void test2(){
        Solution2 solution = new Solution2();
        int[] input = {2,2,2,0,1};
        int result = 0;
        int output = solution.findMin(input);
        assertEquals(result, output);
    }

    @Test
    public void test3(){
        Solution2 solution = new Solution2();
        int[] input = {1};
        int result = 1;
        int output = solution.findMin(input);
        assertEquals(result, output);
    }

    @Test
    public void test4(){
        Solution2 solution = new Solution2();
        int[] input = {3,4,4,4,4,4,4,5,5,6,6,6,6,6,6,6,7,7,7,7,7,7,8,8,8,8,8,8,8,9,9,9,9,9,9,9,9,9,10,10,10,-10,-10,-10,-9,-8,-8,-8,-8,-8,-7,-7,-7,-7,-6,-6,-6,-6,-6,-6,-6,-5,-5,-5,-4,-4,-4,-4,-3,-3,-3,-3,-3,-3,-2,-2,-2,-2,-1,-1,0,0,0,1,1,1,1,1,1,2,2,2,2,2,2,2,2,3,3,3};
        int result = -10;
        int output = solution.findMin(input);
        assertEquals(result, output);
    }
}