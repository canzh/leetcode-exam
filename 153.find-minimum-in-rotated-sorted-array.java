/*
 * @lc app=leetcode id=153 lang=java
 *
 * [153] Find Minimum in Rotated Sorted Array
 *
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (42.94%)
 * Likes:    1098
 * Dislikes: 169
 * Total Accepted:    302.7K
 * Total Submissions: 698.9K
 * Testcase Example:  '[3,4,5,1,2]'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * 
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,4,5,1,2] 
 * Output: 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 * 
 * 
 */
class Solution {
    // diff with peak problem on this is not multiple peak
    // O(n)=logn solution with binary search
    public int findMin(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h && nums[l] > nums[h]) {
            int m = l + (h - l) / 2;
            if (nums[m] > nums[h])
                l = m + 1;
            else // since no duplicate
                h = m;
        }
        return nums[l];
    }

    // similar as peak problem, O(n)=n solution
    public int findMin2(int[] nums) {
        int n = nums.length;
        int peak = n - 1;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1])
                peak = i;
        }
        return nums[(peak + 1) % n];
    }

}
