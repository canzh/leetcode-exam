/*
 * @lc app=leetcode id=14 lang=csharp
 *
 * [14] Longest Common Prefix
 */
public class Solution
{
    public string LongestCommonPrefix(string[] strs)
    {
        if (strs == null || strs.Length == 0) return "";
        if (strs.Length == 1) return strs[0];

        var size = strs.Length;
        int position = 0;
        string result = "";
        char curr = '\0';

        while (true)
        {
            for (int i = 0; i < size; i++)
            {
                var str = strs[i];

                if (str.Length < position + 1)
                {
                    return result;
                }

                curr = strs[0][position];

                if (curr != str[position])
                {
                    return result;
                }
            }

            position += 1;
            result += curr;
        }
    }
}