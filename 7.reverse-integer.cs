/*
 * @lc app=leetcode id=7 lang=csharp
 *
 * [7] Reverse Integer
 */
public class Solution
{
    public int Reverse(int x)
    {
        int mod = 0;
        int result = 0;

        while (x != 0)
        {
            mod = x % 10;
            x = x / 10;
            int tempResult = result * 10 + mod;

            if (tempResult / 10 != result)
            {
                return 0;
            }

            result = tempResult;
        }

        return result;
    }
}

