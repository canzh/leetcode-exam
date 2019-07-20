import java.util.Map;

/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 *
 * https://leetcode.com/problems/minimum-window-substring/description/
 *
 * algorithms
 * Hard (30.72%)
 * Likes:    2394
 * Dislikes: 162
 * Total Accepted:    247.1K
 * Total Submissions: 793.3K
 * Testcase Example:  '"ADOBECODEBANC"\n"ABC"'
 *
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * Example:
 * 
 * 
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * 
 * 
 * Note:
 * 
 * 
 * If there is no such window in S that covers all characters in T, return the
 * empty string "".
 * If there is such window, you are guaranteed that there will always be only
 * one unique minimum window in S.
 * 
 * 
 */
class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length())
            return "";

        Map<Character, Integer> table = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int count = table.getOrDefault(Character.valueOf(c), 0);
            table.put(c, count + 1);
        }

        int counter = table.size(); // required number of unique chars in t
        int begin = 0;
        int end = 0;
        int minLen = Integer.MAX_VALUE;
        int left = 0;

        while (end < s.length()) {
            char c = s.charAt(end);

            if (table.containsKey(c)) {
                int count = table.get(c);
                count--;
                table.put(c, count);

                if (count == 0) {
                    counter--;
                }
            }

            while (counter == 0) {
                if (minLen > end - begin + 1) {
                    left = begin;
                    minLen = end - begin + 1;
                }

                char lc = s.charAt(begin);
                if (table.containsKey(lc)) {
                    int lccount = table.get(lc);
                    lccount++;
                    table.put(lc, lccount);

                    if (lccount > 0) {
                        counter++;
                    }
                }

                begin++;
            }

            end++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(left, left + minLen);
    }
}
