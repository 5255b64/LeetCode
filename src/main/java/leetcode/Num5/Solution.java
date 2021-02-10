package leetcode.Num5;

/*
 * 5. Longest Palindromic Substring
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 * <p>
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */

/**
 * 解题思路： 动态规划 记录到第i个字符为止的最长回文
 * dp数组使用二维数组
 */
public class Solution {
    public String longestPalindrome(String s) {
        char[] str = s.toCharArray();
        if (s.equals("")) {
            return "";
        }
        boolean dp[][] = new boolean[s.length()][s.length()];
        int maxLength = 1;
        int maxPtr = 0;
        for(int j=1;j<s.length();j++){
            for(int i=0;i<j;i++){
                if(str[i]==str[j]){
                    if(j-i<=2){
                        dp[i][j]=true;
                    }if(dp[i+1][j-1]){
                        dp[i][j]=true;
                    }
                }
                if(dp[i][j]){
                    if(maxLength<j-i+1){
                        maxLength=j-i+1;
                        maxPtr=i;
                    }
                }
            }
        }
        return s.substring(maxPtr, maxPtr+maxLength);
    }
}
