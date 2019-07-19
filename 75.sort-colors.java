/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 *
 * https://leetcode.com/problems/sort-colors/description/
 *
 * algorithms
 * Medium (42.12%)
 * Likes:    1754
 * Dislikes: 161
 * Total Accepted:    333.6K
 * Total Submissions: 782.2K
 * Testcase Example:  '[2,0,2,1,1,0]'
 *
 * Given an array with n objects colored red, white or blue, sort them in-place
 * so that objects of the same color are adjacent, with the colors in the order
 * red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red,
 * white, and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this
 * problem.
 * 
 * Example:
 * 
 * 
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * 
 * Follow up:
 * 
 * 
 * A rather straight forward solution is a two-pass algorithm using counting
 * sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then
 * overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 * 
 * 
 */
class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0)
            return;

        int low = 0;
        int high = nums.length - 1;

        for (int i = low; i <= high;) {
            if (nums[i] == 0) {
                swap(nums, i, low);
                i++;
                low++;
            } else if (nums[i] == 2) {
                swap(nums, i, high);
                high--;
            } else {
                i++;
            }
        }
    }

    private void bad(int[] nums) {
        if (nums == null || nums.length == 0)
            return;

        int low = 0;
        int high = nums.length - 1;
        int mid = low;

        while (mid <= high) {
            while (low < nums.length && nums[low] == 0)
                low++;
            while (high > -1 && nums[high] == 2)
                high--;

            if (low >= high)
                return;

            if (mid < low)
                mid = low;

            if (nums[mid] == 1) {
                mid++;
            } else if (nums[mid] == 0) {
                swap(nums, low, mid);
            } else if (nums[mid] == 2) {
                swap(nums, mid, high);
            }
        }
    }

    private void swap(int[] nums, int low, int mid) {
        int temp = nums[low];
        nums[low] = nums[mid];
        nums[mid] = temp;
    }
}
