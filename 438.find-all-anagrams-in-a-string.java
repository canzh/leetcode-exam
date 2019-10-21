import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 *
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 *
 * algorithms
 * Medium (37.93%)
 * Likes:    1803
 * Dislikes: 139
 * Total Accepted:    142.8K
 * Total Submissions: 373.3K
 * Testcase Example:  '"cbaebabacd"\n"abc"'
 *
 * Given a string s and a non-empty string p, find all the start indices of p's
 * anagrams in s.
 * 
 * Strings consists of lowercase English letters only and the length of both
 * strings s and p will not be larger than 20,100.
 * 
 * The order of output does not matter.
 * 
 * Example 1:
 * 
 * Input:
 * s: "cbaebabacd" p: "abc"
 * 
 * Output:
 * [0, 6]
 * 
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of
 * "abc".
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * s: "abab" p: "ab"
 * 
 * Output:
 * [0, 1, 2]
 * 
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 * 
 * 
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null || s.length() < p.length())
            return Collections.EMPTY_LIST;

        int[] chars = new int[26];
        int counter = 0;

        for (int i = 0; i < p.length(); i++) {
            int idx = p.charAt(i) - 'a';
            chars[idx]++;
            idx = s.charAt(i) - 'a';
            chars[idx]--;
        }

        for (int n : chars) {
            if (n != 0)
                counter++;
        }

        List<Integer> result = new LinkedList<>();
        if (counter == 0)
            result.add(0);
        int pLen = p.length();
        for (int i = 0; i < s.length() - p.length(); i++) {
            int c = ++chars[s.charAt(i) - 'a'];
            if (c == 0)
                counter--;
            else if (c == 1)
                counter++;

            c = --chars[s.charAt(i + pLen) - 'a'];
            if (c == 0)
                counter--;
            else if (c == -1)
                counter++;

            if (counter == 0)
                result.add(i + 1);
        }
        return result;
    }
}
