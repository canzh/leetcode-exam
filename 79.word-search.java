import java.util.AbstractMap;
import java.util.List;

/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 *
 * https://leetcode.com/problems/word-search/description/
 *
 * algorithms
 * Medium (31.21%)
 * Likes:    1911
 * Dislikes: 95
 * Total Accepted:    300.5K
 * Total Submissions: 946.7K
 * Testcase Example:  '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once.
 * 
 * Example:
 * 
 * 
 * board =
 * [
 * ⁠ ['A','B','C','E'],
 * ⁠ ['S','F','C','S'],
 * ⁠ ['A','D','E','E']
 * ]
 * 
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 * 
 * 
 */
class Solution {
    public boolean exist(char[][] board, String word) {
        List<Character> result = new ArrayList<Character>();
        List<AbstractMap.SimpleEntry<Integer, Integer>> path = new LinkedList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) != board[i][j])
                    continue;
                path.clear();
                result.add(board[i][j]);
                if (backtrack(board, i, j, word, result, path))
                    return true;
                result.clear();
            }
        }
        return false;
    }

    int[] x_direction = { 0, 0, 1, -1 };
    int[] y_direction = { 1, -1, 0, 0 };

    private boolean backtrack(char[][] board, int x, int y, String word, List<Character> result,
            List<AbstractMap.SimpleEntry<Integer, Integer>> path) {
        String temp = result.stream().map(e -> e.toString()).collect(Collectors.joining());

        if (!word.startsWith(temp))
            return false;

        if (word.equals(temp)) {
            return true;
        }

        int tempX, tempY;
        for (int i = 0; i < 4; i++) {
            tempX = x + x_direction[i];
            tempY = y + y_direction[i];

            if (validate(board, tempX, tempY, path)) {
                result.add(board[tempX][tempY]);
                path.add(new AbstractMap.SimpleEntry(x, y));

                if (backtrack(board, tempX, tempY, word, result, path))
                    return true;

                path.remove(path.size() - 1);
                result.remove(result.size() - 1);
            }
        }

        return false;
    }

    private boolean validate(char[][] board, int tempX, int tempY,
            List<AbstractMap.SimpleEntry<Integer, Integer>> path) {
        int rows = board.length;
        int cols = board[0].length;

        if (tempX < 0 || tempX >= rows)
            return false;
        if (tempY < 0 || tempY >= cols)
            return false;

        if (path.contains(new AbstractMap.SimpleEntry(tempX, tempY)))
            return false;

        return true;
    }
}
