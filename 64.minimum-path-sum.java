/*
 * @lc app=leetcode id=64 lang=java
 *
 * [64] Minimum Path Sum
 *
 * https://leetcode.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (46.81%)
 * Likes:    1416
 * Dislikes: 41
 * Total Accepted:    237.5K
 * Total Submissions: 502.1K
 * Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * Example:
 * 
 * 
 * Input:
 * [
 * [1,3,1],
 * ⁠ [1,5,1],
 * ⁠ [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 * 
 * 
 */
class Solution {
    public int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        int[] minSum = new int[c];
        minSum[0] = grid[0][0];

        // for 1st row
        for (int i = 1; i < c; i++) {
            minSum[i] = minSum[i - 1] + grid[0][i];
        }

        for (int row = 1; row < r; row++) {
            minSum[0] += grid[row][0];

            for (int col = 1; col < c; col++) {
                minSum[col] = Math.min(minSum[col], minSum[col - 1]) + grid[row][col];
            }
        }

        return minSum[c - 1];
    }
}
