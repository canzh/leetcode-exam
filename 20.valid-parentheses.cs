/*
 * @lc app=leetcode id=20 lang=csharp
 *
 * [20] Valid Parentheses
 */
public class Solution
{
    static Dictionary<char, char> MatchMap = new Dictionary<char, char>()
    {
        { ')', '(' },
        { ']', '[' },
        { '}', '{' }
    };

    public bool IsValid(string s)
    {
        var chars = s.ToCharArray();
        System.Collections.Generic.Stack<char> cache = new System.Collections.Generic.Stack<char>();

        foreach (var ch in chars)
        {
            switch (ch)
            {
                case '(':
                case '[':
                case '{':
                    cache.Push(ch);
                    break;
                case ')':
                case ']':
                case '}':
                    if (cache.Count < 1) return false;
                    var pair = cache.Pop();

                    if (MatchMap[ch] != pair) return false;
                    break;
                default:
                    return false;
            }
        }

        if (cache.Count > 0) return false;

        return true;
    }
}

