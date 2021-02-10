package leetcode.Num5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    public void test1() {
        String input = "babad";
        String result = "bab";
        Solution solution = new Solution();
        String output = solution.longestPalindrome(input);
        assertEquals(result, output);
    }

    @Test
    public void test2() {
        String input = "cbbd";
        String result = "bb";
        Solution solution = new Solution();
        String output = solution.longestPalindrome(input);
        assertEquals(result, output);
    }

    @Test
    public void test3() {
        String input = "";
        String result = "";
        Solution solution = new Solution();
        String output = solution.longestPalindrome(input);
        assertEquals(result, output);
    }

    @Test
    public void test4() {
        String input = "a";
        String result = "a";
        Solution solution = new Solution();
        String output = solution.longestPalindrome(input);
        assertEquals(result, output);
    }

    @Test
    public void test5() {
        String input = "aaaa";
        String result = "aaaa";
        Solution solution = new Solution();
        String output = solution.longestPalindrome(input);
        assertEquals(result, output);
    }

    @Test
    public void test6() {
        String input = "bananas";
        String result = "anana";
        Solution solution = new Solution();
        String output = solution.longestPalindrome(input);
        assertEquals(result, output);
    }

    @Test
    public void test7() {
        String input = "ababababababa";
        String result = "ababababababa";
        Solution solution = new Solution();
        String output = solution.longestPalindrome(input);
        assertEquals(result, output);
    }
}