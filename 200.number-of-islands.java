/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 *
 * https://leetcode.com/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (41.44%)
 * Likes:    2858
 * Dislikes: 99
 * Total Accepted:    388.3K
 * Total Submissions: 919.4K
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
 * islands. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges of
 * the grid are all surrounded by water.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * 
 * Output: 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * 
 * Output: 3
 * 
 */
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int ans = 0;
        boolean[][] seen = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (countForCurrent(grid, i, j, seen)) {
                    ans++;
                }
            }
        }

        return ans;
    }

    // return: count for this cell
    boolean countForCurrent(char[][] grid, int x, int y, boolean[][] seen) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0' || seen[x][y])
            return false;

        seen[x][y] = true;

        countForCurrent(grid, x - 1, y, seen);
        countForCurrent(grid, x, y - 1, seen);
        countForCurrent(grid, x + 1, y, seen);
        countForCurrent(grid, x, y + 1, seen);

        return true;
    }
}
