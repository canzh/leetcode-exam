/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 *
 * https://leetcode.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (22.67%)
 * Likes:    1541
 * Dislikes: 1787
 * Total Accepted:    279.7K
 * Total Submissions: 1.2M
 * Testcase Example:  '"12"'
 *
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * 
 * Given a non-empty string containing only digits, determine the total number
 * of ways to decode it.
 * 
 * Example 1:
 * 
 * 
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2
 * 6).
 * 
 */
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;

        char[] chars = s.toCharArray();

        char prev = chars[0];
        int dp1 = prev == '0' ? 0 : 1;
        int dp2 = 1;

        for (int i = 1; i < s.length(); i++) {
            int tmp = dp1;
            if (chars[i] == '0')
                dp1 = 0;

            if (prev == '1' || (prev == '2' && chars[i] < '7')) {
                dp1 += dp2;
            }

            dp2 = tmp;
            prev = chars[i];
        }

        return dp1;
    }
}
