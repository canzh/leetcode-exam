import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode id=212 lang=java
 *
 * [212] Word Search II
 *
 * https://leetcode.com/problems/word-search-ii/description/
 *
 * algorithms
 * Hard (29.24%)
 * Likes:    1209
 * Dislikes: 71
 * Total Accepted:    121.1K
 * Total Submissions: 412.6K
 * Testcase Example:  '[["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]\n["oath","pea","eat","rain"]'
 *
 * Given a 2D board and a list of words from the dictionary, find all words in
 * the board.
 * 
 * Each word must be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once in a word.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: 
 * board = [
 * ⁠ ['o','a','a','n'],
 * ⁠ ['e','t','a','e'],
 * ⁠ ['i','h','k','r'],
 * ⁠ ['i','f','l','v']
 * ]
 * words = ["oath","pea","eat","rain"]
 * 
 * Output: ["eat","oath"]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * All inputs are consist of lowercase letters a-z.
 * The values of words are distinct.
 * 
 * 
 */
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return Collections.EMPTY_LIST;

        List<String> result = new ArrayList<>();
        DictionaryTree trie = DictionaryTree.build(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                backtrack(board, trie, i, j, result);
            }
        }

        Collections.sort(result);
        return result;
    }

    int[] x_dict = { -1, 0, 1, 0 };
    int[] y_dict = { 0, -1, 0, 1 };

    static class DictionaryTree {
        DictionaryTree[] children = new DictionaryTree[26];
        String word;

        static DictionaryTree build(String[] words) {
            DictionaryTree ret = new DictionaryTree();
            for (String w : words) {
                DictionaryTree cur = ret;
                for (char c : w.toCharArray()) {
                    if (cur.children[c - 'a'] == null) {
                        DictionaryTree tmp = new DictionaryTree();
                        cur.children[c - 'a'] = tmp;
                        cur = tmp;
                    } else {
                        cur = cur.children[c - 'a'];
                    }
                }
                cur.word = w;
            }
            return ret;
        }

        boolean hasWordPrefixWith(String word) {
            DictionaryTree cur = this;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null)
                    return false;
                cur = cur.children[c - 'a'];
            }
            return true;
        }
    }

    void backtrack(char[][] board, DictionaryTree trie, int x, int y, List<String> result) {
        char c = board[x][y];

        if (trie.children[c - 'a'] == null) {
            return;
        }
        trie = trie.children[c - 'a'];
        if (trie.word != null) { // found
            result.add(trie.word);
            trie.word = null; // de-duplicate
        }

        for (int i = 0; i < 4; i++) {
            int xm = x_dict[i] + x;
            int ym = y_dict[i] + y;
            if (isValid(board, xm, ym)) {
                char tc = board[x][y];
                board[x][y] = '#';

                backtrack(board, trie, xm, ym, result);

                board[x][y] = tc;
            }
        }
    }

    private boolean isValid(char[][] board, int xm, int ym) {
        if (xm < 0 || xm >= board.length)
            return false;
        if (ym < 0 || ym >= board[0].length)
            return false;

        if (board[xm][ym] == '#')
            return false;

        return true;
    }
}
