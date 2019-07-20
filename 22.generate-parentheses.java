import java.util.List;

/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 *
 * https://leetcode.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (54.80%)
 * Likes:    2885
 * Dislikes: 183
 * Total Accepted:    354.1K
 * Total Submissions: 637.5K
 * Testcase Example:  '3'
 *
 * 
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * 
 * 
 * For example, given n = 3, a solution set is:
 * 
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(n, result, "");
        return result;
    }

    private void helper(int n, List<String> result, String current) {
        if (current.length() == n * 2) {
            result.add(current);
            return;
        }

        for (char c : "()".toCharArray()) {
            if (isValid(current, c, n)) {
                helper(n, result, current + c);
            }
        }
    }

    private boolean isValid(String str, char c, int n) {
        int leftCount = 0;
        int rightCount = 0;

        for (char chr : str.toCharArray()) {
            if (chr == '(')
                leftCount++;
            else
                rightCount++;
        }

        if (c == '(') {
            return leftCount < n;
        }

        return leftCount > rightCount;
    }
}
