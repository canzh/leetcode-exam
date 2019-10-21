/*
 * @lc app=leetcode id=289 lang=java
 *
 * [289] Game of Life
 *
 * https://leetcode.com/problems/game-of-life/description/
 *
 * algorithms
 * Medium (46.91%)
 * Likes:    1050
 * Dislikes: 197
 * Total Accepted:    125.4K
 * Total Submissions: 265.8K
 * Testcase Example:  '[[0,1,0],[0,0,1],[1,1,1],[0,0,0]]'
 *
 * According to the Wikipedia's article: "The Game of Life, also known simply
 * as Life, is a cellular automaton devised by the British mathematician John
 * Horton Conway in 1970."
 * 
 * Given a board with m by n cells, each cell has an initial state live (1) or
 * dead (0). Each cell interacts with its eight neighbors (horizontal,
 * vertical, diagonal) using the following four rules (taken from the above
 * Wikipedia article):
 * 
 * 
 * Any live cell with fewer than two live neighbors dies, as if caused by
 * under-population.
 * Any live cell with two or three live neighbors lives on to the next
 * generation.
 * Any live cell with more than three live neighbors dies, as if by
 * over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if
 * by reproduction.
 * 
 * 
 * Write a function to compute the next state (after one update) of the board
 * given its current state. The next state is created by applying the above
 * rules simultaneously to every cell in the current state, where births and
 * deaths occur simultaneously.
 * 
 * Example:
 * 
 * 
 * Input: 
 * [
 * [0,1,0],
 * [0,0,1],
 * [1,1,1],
 * [0,0,0]
 * ]
 * Output: 
 * [
 * [0,0,0],
 * [1,0,1],
 * [0,1,1],
 * [0,1,0]
 * ]
 * 
 * 
 * Follow up:
 * 
 * 
 * Could you solve it in-place? Remember that the board needs to be updated at
 * the same time: You cannot update some cells first and then use their updated
 * values to update other cells.
 * In this question, we represent the board using a 2D array. In principle, the
 * board is infinite, which would cause problems when the active area
 * encroaches the border of the array. How would you address these problems?
 * 
 * 
 */
class Solution {
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                live(board, rows, cols, i, j);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 2)
                    board[i][j] = 0;
                else if (board[i][j] == 3)
                    board[i][j] = 1;
            }
        }
    }

    private void live(int[][] board, int rows, int cols, int r, int c) {
        int n = 0;

        // 2 to die
        // 3 to live
        if (r - 1 >= 0 && c - 1 >= 0 && (board[r - 1][c - 1] == 1 || board[r - 1][c - 1] == 2))
            n++;
        if (r - 1 >= 0 && (board[r - 1][c] == 1 || board[r - 1][c] == 2))
            n++;
        if (r - 1 >= 0 && c + 1 < cols && (board[r - 1][c + 1] == 1 || board[r - 1][c + 1] == 2))
            n++;
        if (c + 1 < cols && board[r][c + 1] == 1)
            n++;
        if (r + 1 < rows && c + 1 < cols && board[r + 1][c + 1] == 1)
            n++;
        if (r + 1 < rows && board[r + 1][c] == 1)
            n++;
        if (r + 1 < rows && c - 1 >= 0 && board[r + 1][c - 1] == 1)
            n++;
        if (c - 1 >= 0 && (board[r][c - 1] == 1 || board[r][c - 1] == 2))
            n++;

        // to die
        if (board[r][c] == 1 && (n < 2 || n > 3))
            board[r][c] = 2;

        // to live
        if (board[r][c] == 0 && n == 3)
            board[r][c] = 3;
    }

    // GOOD solution to calc lives from leetcode discussion
    public int liveNeighbors(int[][] board, int m, int n, int i, int j) {
        int lives = 0;
        for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
            for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
                lives += board[x][y] & 1;
            }
        }
        lives -= board[i][j] & 1;
        return lives;
    }
}
