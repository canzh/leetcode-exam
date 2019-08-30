import java.util.List;

/*
 * @lc app=leetcode id=386 lang=java
 *
 * [386] Lexicographical Numbers
 *
 * https://leetcode.com/problems/lexicographical-numbers/description/
 *
 * algorithms
 * Medium (47.28%)
 * Likes:    406
 * Dislikes: 62
 * Total Accepted:    43.4K
 * Total Submissions: 91.4K
 * Testcase Example:  '13'
 *
 * Given an integer n, return 1 - n in lexicographical order.
 * 
 * For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
 * 
 * Please optimize your algorithm to use less time and space. The input size
 * may be as large as 5,000,000.
 * 
 */
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new LinkedList<>();
        // helper(res, 0, 0, Integer.toString(n).length(), n);

        for (int i = 1; i < 10; i++) {
            dfs(res, i, n);
        }
        return res;
    }

    // k for 第几位数字
    // m for 总共位数
    private void helper(List<Integer> result, int current, int k, int m, int n) {
        if (k > m || current > n)
            return;
        if (current > 0)
            result.add(current);

        for (int i = 0; i < 10; i++) {
            if (k == 0 && i == 0)
                continue;

            helper(result, current * 10 + i, k + 1, m, n);
        }
    }

    private void dfs(List<Integer> result, int cur, int n) {
        if (cur > n)
            return;

        result.add(cur);

        for (int i = 0; i < 10; i++) {
            if (cur * 10 + i > n)
                return;
            dfs(result, cur * 10 + i, n);
        }
    }
}
