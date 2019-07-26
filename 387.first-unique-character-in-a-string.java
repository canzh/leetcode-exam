/*
 * @lc app=leetcode id=387 lang=java
 *
 * [387] First Unique Character in a String
 *
 * https://leetcode.com/problems/first-unique-character-in-a-string/description/
 *
 * algorithms
 * Easy (49.98%)
 * Likes:    1088
 * Dislikes: 82
 * Total Accepted:    291.7K
 * Total Submissions: 579.1K
 * Testcase Example:  '"leetcode"'
 *
 * 
 * Given a string, find the first non-repeating character in it and return it's
 * index. If it doesn't exist, return -1.
 * 
 * Examples:
 * 
 * s = "leetcode"
 * return 0.
 * 
 * s = "loveleetcode",
 * return 2.
 * 
 * 
 * 
 * 
 * Note: You may assume the string contain only lowercase letters.
 * 
 */
class Solution {
    // better, more concise
    public int firstUniqChar(String s) {
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1)
                return i;
        }

        return -1;
    }

    public int firstUniqChar2(String s) {
        int[] idxArr = new int[26];
        Arrays.fill(idxArr, -1);

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (idxArr[idx] == -1) {
                idxArr[idx] = i;
            } else {
                idxArr[idx] = -2;
            }
        }
        int minIdx = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (idxArr[i] >= 0)
                minIdx = Math.min(minIdx, idxArr[i]);
        }

        return minIdx == Integer.MAX_VALUE ? -1 : minIdx;
    }
}
