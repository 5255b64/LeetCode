package leetcode.Num6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    public void test1(){
        Solution solution=new Solution();
        String s = "PAYPALISHIRING";
        int numRows = 3;
        String result = "PAHNAPLSIIGYIR";
        String output = solution.convert(s,numRows);
        assertEquals(result,output);
    }

    @Test
    public void test2(){
        Solution solution=new Solution();
        String s = "PAYPALISHIRING";
        int numRows = 4;
        String result = "PINALSIGYAHRPI";
        String output = solution.convert(s,numRows);
        assertEquals(result,output);
    }

    @Test
    public void test3(){
        Solution solution=new Solution();
        String s = "A";
        int numRows = 1;
        String result = "A";
        String output = solution.convert(s,numRows);
        assertEquals(result,output);
    }
}