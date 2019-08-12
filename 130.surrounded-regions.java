/*
 * @lc app=leetcode id=130 lang=java
 *
 * [130] Surrounded Regions
 *
 * https://leetcode.com/problems/surrounded-regions/description/
 *
 * algorithms
 * Medium (23.56%)
 * Likes:    850
 * Dislikes: 448
 * Total Accepted:    155.5K
 * Total Submissions: 660K
 * Testcase Example:  '[["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]'
 *
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions
 * surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded
 * region.
 * 
 * Example:
 * 
 * 
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 
 * 
 * After running your function, the board should be:
 * 
 * 
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 
 * 
 * Explanation:
 * 
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on
 * the border of the board are not flipped to 'X'. Any 'O' that is not on the
 * border and it is not connected to an 'O' on the border will be flipped to
 * 'X'. Two cells are connected if they are adjacent cells connected
 * horizontally or vertically.
 * 
 */
class Solution {
    // First, check the four border of the matrix. If there is a element is
    // 'O', alter it and all its neighbor 'O' elements to '1'.
    // Then ,alter all the 'O' to 'X'
    // At last,alter all the '1' to 'O'

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return;

        int rows = board.length;
        int cols = board[0].length;

        // mark vertical edge
        for (int i = 0; i < rows; i++) {
            flipEdge(board, i, 0);

            if (cols > 1) {
                flipEdge(board, i, cols - 1);
            }
        }

        // mark horizontal edge
        for (int i = 0; i < cols; i++) {
            flipEdge(board, 0, i);

            if (rows > 1) {
                flipEdge(board, rows - 1, i);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == '1')
                    board[i][j] = 'O';
            }
        }
    }

    void flipEdge(char[][] b, int r, int c) {
        int rows = b.length;
        int cols = b[0].length;

        if (r < 0 || r >= rows || c < 0 || c >= cols)
            return;

        if (b[r][c] != 'O')
            return;

        b[r][c] = '1';

        flipEdge(b, r + 1, c);
        flipEdge(b, r - 1, c);
        flipEdge(b, r, c + 1);
        flipEdge(b, r, c - 1);
    }
}
