/*
 * @lc app=leetcode id=459 lang=java
 *
 * [459] Repeated Substring Pattern
 */

// @lc code=start
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0)
            return false;
        return (s + s).substring(1, s.length() * 2 - 1).contains(s);
    }
}
// @lc code=end
