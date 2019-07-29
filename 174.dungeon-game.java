/*
 * @lc app=leetcode id=174 lang=java
 *
 * [174] Dungeon Game
 *
 * https://leetcode.com/problems/dungeon-game/description/
 *
 * algorithms
 * Hard (27.06%)
 * Likes:    746
 * Dislikes: 17
 * Total Accepted:    68.7K
 * Total Submissions: 249.6K
 * Testcase Example:  '[[-2,-3,3],[-5,-10,1],[10,30,-5]]'
 *
 * table.dungeon, .dungeon th, .dungeon td {
 * ⁠ border:3px solid black;
 * }
 * 
 * ⁠.dungeon th, .dungeon td {
 * ⁠   text-align: center;
 * ⁠   height: 70px;
 * ⁠   width: 70px;
 * }
 * 
 * The demons had captured the princess (P) and imprisoned her in the
 * bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid
 * out in a 2D grid. Our valiant knight (K) was initially positioned in the
 * top-left room and must fight his way through the dungeon to rescue the
 * princess.
 * 
 * The knight has an initial health point represented by a positive integer. If
 * at any point his health point drops to 0 or below, he dies immediately.
 * 
 * Some of the rooms are guarded by demons, so the knight loses health
 * (negative integers) upon entering these rooms; other rooms are either empty
 * (0's) or contain magic orbs that increase the knight's health (positive
 * integers).
 * 
 * In order to reach the princess as quickly as possible, the knight decides to
 * move only rightward or downward in each step.
 * 
 * 
 * 
 * Write a function to determine the knight's minimum initial health so that he
 * is able to rescue the princess.
 * 
 * For example, given the dungeon below, the initial health of the knight must
 * be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN ->
 * DOWN.
 * 
 * 
 * 
 * 
 * -2 (K)
 * -3
 * 3
 * 
 * 
 * -5
 * -10
 * 1
 * 
 * 
 * 10
 * 30
 * -5 (P)
 * 
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * The knight's health has no upper bound.
 * Any room can contain threats or power-ups, even the first room the knight
 * enters and the bottom-right room where the princess is imprisoned.
 * 
 * 
 */
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int rows = dungeon.length;
        int cols = dungeon[0].length;

        dungeon[rows - 1][cols - 1] = Math.max(1, 1 - dungeon[rows - 1][cols - 1]);

        for (int i = rows - 2; i >= 0; i--) {
            dungeon[i][cols - 1] = Math.max(1, dungeon[i + 1][cols - 1] - dungeon[i][cols - 1]);
        }

        for (int i = cols - 2; i >= 0; i--) {
            dungeon[rows - 1][i] = Math.max(1, dungeon[rows - 1][i + 1] - dungeon[rows - 1][i]);
        }

        for (int i = rows - 2; i >= 0; i--) {
            for (int j = cols - 2; j >= 0; j--) {
                dungeon[i][j] = Math.max(1, Math.min(dungeon[i + 1][j], dungeon[i][j + 1]) - dungeon[i][j]);
            }
        }
        return dungeon[0][0];
    }

    // top-down dp solution for intuition
    int[][] mem;

    private int helper(int[][] dungeon, int i, int j) {
        if (i >= dungeon.length || j >= dungeon[0].length)
            return Integer.MAX_VALUE;
        if (mem[i][j] > 0)
            return mem[i][j];
        int health = Integer.MAX_VALUE;
        health = Math.min(health, helper(dungeon, i + 1, j));
        health = Math.min(health, helper(dungeon, i, j + 1));
        health = health == Integer.MAX_VALUE ? 1 : health; // this only happens with i, j is P already
        int ret = health > dungeon[i][j] ? (health - dungeon[i][j]) : 1;
        mem[i][j] = ret;
        return ret;
    }

    public int dpTopdown(int[][] dungeon) {
        if (dungeon.length == 0)
            return 0;
        mem = new int[dungeon.length][dungeon[0].length];
        return helper(dungeon, 0, 0);
    }
}
