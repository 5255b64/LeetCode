package leetcode.Num207;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    public void test1() {
        Solution s = new Solution();
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        boolean result = s.canFinish(numCourses, prerequisites);
        assertEquals(true, result);
    }

    @Test
    public void test2() {
        Solution s = new Solution();
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};
        boolean result = s.canFinish(numCourses, prerequisites);
        assertEquals(false, result);
    }

    @Test
    public void test3() {
        Solution s = new Solution();
        int numCourses = 2;
        int[][] prerequisites = {{0, 1}};
        boolean result = s.canFinish(numCourses, prerequisites);
        assertEquals(true, result);
    }
}