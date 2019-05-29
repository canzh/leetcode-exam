/*
 * @lc app=leetcode id=5 lang=csharp
 *
 * [5] Longest Palindromic Substring
 */
public class Solution
{
    public string LongestPalindrome(string s)
    {
        // Solution 1: Expand Around Center O(n^2)
        // Solution 2: Manacher's Algorithm O(n)

        if (s == null || s.Length < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.Length; i++)
        {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = System.Math.Max(len1, len2);
            if (len > end - start)
            {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.Substring(start, end - start + 1);
    }

    private int expandAroundCenter(string s, int left, int right)
    {
        int L = left, R = right;
        while (L >= 0 && R < s.Length && s[L] == s[R])
        {
            L--;
            R++;
        }
        return R - L - 1;
    }
}

