/*
 * @lc app=leetcode id=28 lang=csharp
 *
 * [28] Implement strStr()
 */
public class Solution
{
    public int StrStr(string haystack, string needle)
    {
        if (needle.Length == 0) return 0;

        for (int i = 0; i <= haystack.Length - needle.Length; i++)
        {
            int j = 0;

            while (j < needle.Length && needle[j] == haystack[i + j]) j++;

            if (j == needle.Length) return i;
        }

        return -1;
    }
}

