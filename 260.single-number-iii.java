/*
 * @lc app=leetcode id=260 lang=java
 *
 * [260] Single Number III
 *
 * https://leetcode.com/problems/single-number-iii/description/
 *
 * algorithms
 * Medium (57.76%)
 * Likes:    956
 * Dislikes: 80
 * Total Accepted:    113.2K
 * Total Submissions: 195.5K
 * Testcase Example:  '[1,2,1,3,2,5]'
 *
 * Given an array of numbers nums, in which exactly two elements appear only
 * once and all the other elements appear exactly twice. Find the two elements
 * that appear only once.
 * 
 * Example:
 * 
 * 
 * Input:  [1,2,1,3,2,5]
 * Output: [3,5]
 * 
 * Note:
 * 
 * 
 * The order of the result is not important. So in the above example, [5, 3] is
 * also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement
 * it using only constant space complexity?
 * 
 */
class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int n : nums) {
            xor ^= n;
        }

        // Why diff &= ~(diff - 1)
        // First, this the original formula to get the last set bit. The diff &= -diff
        // is just an abbreviation with the knowledge of ~(diff - 1) = - (diff - 1) - 1
        // = -diff.
        int rightmostbit = (xor & (xor - 1)) ^ xor;

        int num1 = 0, num2 = 0;
        for (int n : nums) {
            if ((rightmostbit & n) == 0) {
                num1 ^= n;
            } else {
                num2 ^= n;
            }
        }

        return new int[] { num1, num2 };
    }
}
