/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 *
 * https://leetcode.com/problems/jump-game/description/
 *
 * algorithms
 * Medium (31.86%)
 * Likes:    2001
 * Dislikes: 201
 * Total Accepted:    273K
 * Total Submissions: 850.9K
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * Example 1:
 * 
 * 
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last
 * index.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its
 * maximum
 * jump length is 0, which makes it impossible to reach the last index.
 * 
 * 
 */
class Solution {
    public boolean canJump(int[] nums) {
        // Greedy Solution

        int lastGoodPos = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= lastGoodPos) {
                lastGoodPos = i;
            }
        }

        return lastGoodPos == 0;
    }

    boolean canJumpByDynamicProgramming(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        memo[memo.length - 1] = 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            int fareastPos = Math.min(nums.length - 1, i + nums[i]);

            for (int j = i; j <= fareastPos; j++) {
                if (memo[j] == 1) {
                    memo[i] = 1;
                    break;
                }
            }
        }

        return memo[0] == 1;
    }
}
