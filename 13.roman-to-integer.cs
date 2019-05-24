/*
 * @lc app=leetcode id=13 lang=csharp
 *
 * [13] Roman to Integer
 */
public class Solution
{
    /*
        additional thought:
        1. whether the input can garrenty it's valid roman expression
        2. how if requires the verify the expression
     */
    string symbols = "IVXLCDM";
    int[] numbers = { 1, 5, 10, 50, 100, 500, 1000 };

    public int RomanToInt(string s)
    {
        var chars = s.ToCharArray();

        int result = 0;
        int i = 0;
        for (; i < chars.Length - 1; i++)
        {
            var index1 = symbols.IndexOf(chars[i]);
            var index2 = symbols.IndexOf(chars[i + 1]);

            if (index1 < index2)
            {
                result += numbers[index2] - numbers[index1];
                i += 1;
                continue;
            }

            result += numbers[index1];
        }

        if (i == chars.Length - 1)
        {
            result += numbers[symbols.IndexOf(chars[i])];
        }

        return result;
    }
}

