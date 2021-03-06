import java.util.Arrays;

/*
 * @lc app=leetcode id=395 lang=java
 *
 * [395] Longest Substring with At Least K Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/description/
 *
 * algorithms
 * Medium (39.19%)
 * Likes:    824
 * Dislikes: 77
 * Total Accepted:    53.1K
 * Total Submissions: 135.3K
 * Testcase Example:  '"aaabb"\n3'
 *
 * 
 * Find the length of the longest substring T of a given string (consists of
 * lowercase letters only) such that every character in T appears no less than
 * k times.
 * 
 * 
 * Example 1:
 * 
 * Input:
 * s = "aaabb", k = 3
 * 
 * Output:
 * 3
 * 
 * The longest substring is "aaa", as 'a' is repeated 3 times.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * s = "ababbc", k = 2
 * 
 * Output:
 * 5
 * 
 * The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is
 * repeated 3 times.
 * 
 * 
 */
class Solution {
    // From discussion:
    // this problem prompts us to use two pointer method, however it's quite
    // difficult to decide the condition to expand (j++) and shrink (i++) - that's
    // where the above posted solution rocks. thanks again!

    // if it helps, here are some explanations to understand above code:
    // how do we explore all possible solutions (substrings that satisfy given
    // constraints) ?

    // this post's solution explores this way
    // -- find all sub-strings which have "h=1" unique character(s) and each
    // character in the substring repeats at least "k" times
    // -- find all sub-strings which have "h=2" unique character(s) and each
    // character in the substring repeats at least "k" times
    // -- ....
    // -- find all sub-strings which have "h=26" unique character(s) and each
    // character in the substring repeats at least "k" times
    // -- and we're done! at h = 26, we're done. Take max of all the above valid
    // substrings (by tracking with --max-- variable) -- that'll be our answer.
    // Details: (for a fixed h)

    // basically, we want to find a window (i to j) which has "h" unique chars and
    // if all h occur at least K times, we have a candidate solution
    // [Rules for window Expansion] so expand (j++) as long as the num of unique
    // characters between 'i' to 'j' are h or less (unique <= h)
    // during expansion, also track chars that are "noLessThanK" (which occur at
    // least k)
    // end of the loop update max (max len of valid window which have h unique chars
    // and all h have at least k occurences)
    // once we see -- unique = h + 1 -- , we just expanded our window with (h+1)th
    // unique char, so we should start to shrink now.
    // [Rules to window Shrink window] shrink as long as we have unique chars > h
    // (update counts, unique, NoLessThanK along the way)
    public int longestSubstring(String s, int k) {
        int[] counts = new int[26];
        int uniqueChars, hi, lo, maxLen = 0, noLessThanKChars;

        for (int h = 1; h <= 26; h++) {
            Arrays.fill(counts, 0);
            hi = 0;
            lo = 0;
            uniqueChars = 0;
            noLessThanKChars = 0;

            while (hi < s.length()) {
                if (uniqueChars <= h) {
                    int idx = s.charAt(hi) - 'a';
                    if (counts[idx] == 0)
                        uniqueChars++;
                    counts[idx]++;
                    if (counts[idx] == k)
                        noLessThanKChars++;
                    hi++; // expand sliding window
                } else {
                    int idx = s.charAt(lo) - 'a';
                    if (counts[idx] == k)
                        noLessThanKChars--;
                    counts[idx]--;
                    if (counts[idx] == 0)
                        uniqueChars--;
                    lo++; // shrink window
                }
                if (uniqueChars == h && uniqueChars == noLessThanKChars) {
                    maxLen = Math.max(hi - lo, maxLen);
                }
            }
        }

        return maxLen;
    }
}
