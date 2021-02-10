package leetcode.Num216;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    public void test1() {
        Solution s = new Solution();
        int k = 3;
        int n = 7;
        String resultExpected = "[[1, 2, 4]]";
        List<List<Integer>> result = s.combinationSum3(k, n);
        assertEquals(resultExpected, result.toString());
    }

    @Test
    public void test2() {
        Solution s = new Solution();
        int k = 3;
        int n = 9;
        String resultExpected = "[[1, 2, 6], [1, 3, 5], [2, 3, 4]]";
        List<List<Integer>> result = s.combinationSum3(k, n);
        assertEquals(resultExpected, result.toString());
    }

    @Test
    public void test3() {
        Solution s = new Solution();
        int k = 9;
        int n = 45;
        String resultExpected = "[[1, 2, 3, 4, 5, 6, 7, 8, 9]]";
        List<List<Integer>> result = s.combinationSum3(k, n);
        assertEquals(resultExpected, result.toString());
    }
}