package leetcode.Num154;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    public void test1(){
        Solution solution = new Solution();
        int[] input = {1,3,5};
        int result = 1;
        int output = solution.findMin(input);
        assertEquals(result, output);
    }

    @Test
    public void test2(){
        Solution solution = new Solution();
        int[] input = {2,2,2,0,1};
        int result = 0;
        int output = solution.findMin(input);
        assertEquals(result, output);
    }
}