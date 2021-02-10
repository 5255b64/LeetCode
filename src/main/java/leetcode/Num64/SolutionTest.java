package leetcode.Num64;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    public void test1(){
        int[][] input = {{1,3,1},
                {1,5,1},
                {4,2,1}};
        int result = 7;
        Solution solution=new Solution();
        int output = solution.minPathSum(input);
        assertEquals(result,output);
    }

}