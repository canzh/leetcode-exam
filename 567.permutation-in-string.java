/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 *
 * https://leetcode.com/problems/permutation-in-string/description/
 *
 * algorithms
 * Medium (38.34%)
 * Likes:    677
 * Dislikes: 34
 * Total Accepted:    50.3K
 * Total Submissions: 129.9K
 * Testcase Example:  '"ab"\n"eidbaooo"'
 *
 * Given two strings s1 and s2, write a function to return true if s2 contains
 * the permutation of s1. In other words, one of the first string's
 * permutations is the substring of the second string.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * The input strings only contain lower case letters.
 * The length of both given strings is in range [1, 10,000].
 * 
 * 
 */
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // optimize space and time to O() = l1 + (l2-l1);
        if (s1.length() > s2.length())
            return false;

        int[] nums = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            nums[s1.charAt(i) - 'a']++;
            nums[s2.charAt(i) - 'a']--;
        }

        int zeroCount = 0;
        for (int i = 0; i < 26; i++) {
            if (nums[i] == 0)
                zeroCount++;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            if (zeroCount == 26)
                return true;

            // plus 1 when slide out from left
            nums[s2.charAt(i - s1.length()) - 'a']++;

            if (nums[s2.charAt(i - s1.length()) - 'a'] == 1)
                zeroCount--;
            else if (nums[s2.charAt(i - s1.length()) - 'a'] == 0)
                zeroCount++;

            // minus 1 when slide in from right
            nums[s2.charAt(i) - 'a']--;

            if (nums[s2.charAt(i) - 'a'] == 0)
                zeroCount++;
            else if (nums[s2.charAt(i) - 'a'] == -1)
                zeroCount--;
        }

        return zeroCount == 26;
    }

    public boolean checkInclusion2(String s1, String s2) {
        int[] nums = new int[26];
        int counter = 0;

        // Arrays.fill(nums, 0);

        for (int i = 0; i < s1.length(); i++) {
            if (nums[s1.charAt(i) - 'a'] == 0)
                counter++;
            nums[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            if (nums[s2.charAt(i) - 'a'] > 0) {
                int[] cur = new int[26];
                int j = i;
                int curCounter = 0;
                while (j < s2.length()) {
                    int idx = s2.charAt(j) - 'a';
                    cur[idx]++;

                    if (cur[idx] == nums[idx]) {
                        curCounter++;
                    } else if (cur[idx] > nums[idx]) {
                        break; // has additional char
                    }

                    if (curCounter == counter) {
                        return true;
                    }
                    j++;
                }
            }
        }

        return false;
    }
}
