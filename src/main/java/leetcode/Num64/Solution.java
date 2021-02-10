package leetcode.Num64;

/*
 * 64. Minimum Path Sum
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 *
 * https://leetcode-cn.com/problems/minimum-path-sum/
 */

/**
 * 解题思路： 动态规划
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int maxI = grid.length;
        int maxJ = grid[0].length;

        int[][] dp = new int[maxI][maxJ];

        dp[0][0]=grid[0][0];

        for(int i=0;i<maxI;i++){
            for(int j=0;j<maxJ;j++){
                if(i==0&&j==0){
                    // 初始点
                    continue;
                }else if(i==0){
                    // 第一行 只能从左边到达
                    dp[i][j]=dp[i][j-1]+grid[i][j];
                }else if(j==0) {
                    // 第一列 只能从上边到达
                    dp[i][j]=dp[i-1][j]+grid[i][j];
                }else{
                    // 其他情况 从左边或者上边到达
                    dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j])+grid[i][j];
                }
            }
        }

        return dp[maxI-1][maxJ-1];
    }
}
