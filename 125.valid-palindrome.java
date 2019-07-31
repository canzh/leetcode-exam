/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 *
 * https://leetcode.com/problems/valid-palindrome/description/
 *
 * algorithms
 * Easy (31.64%)
 * Likes:    639
 * Dislikes: 1883
 * Total Accepted:    381.2K
 * Total Submissions: 1.2M
 * Testcase Example:  '"A man, a plan, a canal: Panama"'
 *
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * Note: For the purpose of this problem, we define empty string as valid
 * palindrome.
 * 
 * Example 1:
 * 
 * 
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "race a car"
 * Output: false
 * 
 * 
 */
class Solution {
    public boolean isPalindrome(String s) {
        char[] cs = s.toCharArray();
        for (int i = 0, j = cs.length - 1; i < j;) {
            if (!Character.isLetterOrDigit(cs[i]))
                i++;
            else if (!Character.isLetterOrDigit(cs[j]))
                j--;
            else if (Character.toLowerCase(cs[i++]) != Character.toLowerCase(cs[j--]))
                return false;
        }
        return true;
    }

    public boolean isPalindrome2(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        int low = 0, high = chars.length - 1;
        while (low < high) {
            while (low <= high && !isAlphaNumeric(chars[low]))
                low++;
            while (high >= low && !isAlphaNumeric(chars[high]))
                high--;

            if (low < high && chars[low] != chars[high])
                return false;

            low++;
            high--;
        }
        return true;
    }

    boolean isAlphaNumeric(char c) {
        if (c >= 'a' && c <= 'z')
            return true;

        if (c >= '0' && c <= '9')
            return true;

        return false;
    }
}
