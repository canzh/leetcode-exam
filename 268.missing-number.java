/*
 * @lc app=leetcode id=268 lang=java
 *
 * [268] Missing Number
 *
 * https://leetcode.com/problems/missing-number/description/
 *
 * algorithms
 * Easy (48.81%)
 * Likes:    992
 * Dislikes: 1404
 * Total Accepted:    297.3K
 * Total Submissions: 608.5K
 * Testcase Example:  '[3,0,1]'
 *
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
 * find the one that is missing from the array.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,0,1]
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * 
 * 
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement
 * it using only constant extra space complexity?
 */
class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        return n * (n + 1) / 2 - sum;
    }

    // index XOR value => left is missing one
    int bitXor(int[] nums) {
        int ret = nums.length;
        for (int i = 0; i < nums.length; i++) {
            ret ^= i ^ nums[i];
        }
        return ret;
    }

    // no overflow risk
    // (index + 1) - val cumulatively
    int sumOptimized(int[] nums) {
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            ret += (i + 1) - nums[i];
        }
        return ret;
    }
}
