/*
 * @lc app=leetcode id=189 lang=java
 *
 * [189] Rotate Array
 *
 * https://leetcode.com/problems/rotate-array/description/
 *
 * algorithms
 * Easy (30.01%)
 * Likes:    1469
 * Dislikes: 623
 * Total Accepted:    321.7K
 * Total Submissions: 1M
 * Testcase Example:  '[1,2,3,4,5,6,7]\n3'
 *
 * Given an array, rotate the array to the right by k steps, where k is
 * non-negative.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation: 
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * 
 * 
 * Note:
 * 
 * 
 * Try to come up as many solutions as you can, there are at least 3 different
 * ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 * 
 */
class Solution {
    // note for index when move to the next, it may has chance
    // next just jump to same idx in the next round
    // e.g. [1,2,3,4,5,6] k=2
    public void rotate(int[] nums, int k) {
        k = k % nums.length;

        int tmp;
        int prev;
        int next;
        int placed = 0;

        for (int i = 0; placed < nums.length; i++) {
            next = i;
            prev = nums[next];

            do {
                next = (next + k) % nums.length;

                tmp = nums[next];
                nums[next] = prev;
                prev = tmp;

                placed++;
            } while (next != i);
        }
    }

    public void rotate2(int[] nums, int k) {
        k = k % nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    void reverse(int[] nums, int low, int high) {
        while (low < high) {
            int tmp = nums[low];
            nums[low] = nums[high];
            nums[high] = tmp;
            low++;
            high--;
        }
    }
}
