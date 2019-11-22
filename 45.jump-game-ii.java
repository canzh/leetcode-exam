/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 *
 * https://leetcode.com/problems/jump-game-ii/description/
 *
 * algorithms
 * Hard (29.16%)
 * Likes:    1624
 * Dislikes: 89
 * Total Accepted:    206.5K
 * Total Submissions: 706.8K
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * Example:
 * 
 * 
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 * ⁠   Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * 
 * Note:
 * 
 * You can assume that you can always reach the last index.
 * 
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int ans = 0, fareast = 0, lastFareast = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            fareast = Math.max(nums[i] + i, fareast);

            if (i == lastFareast) {
                ans++;
                lastFareast = fareast;

                if (fareast >= nums.length - 1) {
                    break;
                }
            }
        }

        return ans;
    }
}
// @lc code=end
