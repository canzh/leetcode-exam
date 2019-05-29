/*
 * @lc app=leetcode id=3 lang=csharp
 *
 * [3] Longest Substring Without Repeating Characters
 */
public class Solution
{
    public int LengthOfLongestSubstring(string s)
    {
        // Solution 1:

        // int max = 0;
        // System.Collections.Generic.HashSet<char> cache = new System.Collections.Generic.HashSet<char>();

        // for (int i = 0; i < s.Length; i++)
        // {
        //     int j = i;

        //     for (; j < s.Length; j++)
        //     {
        //         if (cache.Contains(s[j]))
        //         {
        //             break;
        //         }

        //         cache.Add(s[j]);
        //     }

        //     if (j - i > max) max = j - i;
        //     cache.Clear();
        // }

        // return max > cache.Count ? max : cache.Count;

        // Solution 2: Sliding Window

        int i = 0, j = 0, max = 0;
        System.Collections.Generic.HashSet<char> cache = new System.Collections.Generic.HashSet<char>();

        while (i < s.Length && j < s.Length)
        {
            if (!cache.Contains(s[j]))
            {
                cache.Add(s[j]);
                j++;
                max = j - i > max ? j - i : max;
            }
            else
            {
                cache.Remove(s[i]);
                i++;
            }
        }

        return max;
    }
}

