/*
 * @lc app=leetcode id=357 lang=java
 *
 * [357] Count Numbers with Unique Digits
 *
 * https://leetcode.com/problems/count-numbers-with-unique-digits/description/
 *
 * algorithms
 * Medium (47.41%)
 * Likes:    276
 * Dislikes: 678
 * Total Accepted:    66.5K
 * Total Submissions: 140.2K
 * Testcase Example:  '2'
 *
 * Given a non-negative integer n, count all numbers with unique digits, x,
 * where 0 ≤ x < 10^n.
 * 
 * 
 * Example:
 * 
 * 
 * Input: 2
 * Output: 91 
 * Explanation: The answer should be the total numbers in the range of 0 ≤ x <
 * 100, 
 * excluding 11,22,33,44,55,66,77,88,99
 * 
 * 
 */
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n <= 0)
            return 1;
        int ans = 10, uniqueDigits = 9, availableDigits = 9;
        while (--n > 0 && availableDigits > 0) {
            uniqueDigits *= availableDigits;
            ans += uniqueDigits;
            availableDigits--;
        }
        return ans;
    }
}
