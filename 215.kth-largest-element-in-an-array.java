/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 *
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 *
 * algorithms
 * Medium (48.72%)
 * Likes:    2206
 * Dislikes: 179
 * Total Accepted:    403.7K
 * Total Submissions: 826.6K
 * Testcase Example:  '[3,2,1,5,6,4]\n2'
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth
 * largest element in the sorted order, not the kth distinct element.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 * 
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;

        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int ret = partition(nums, low, high);

            if (ret > k) {
                high = ret - 1;
            } else if (ret < k) {
                low = ret + 1;
            } else {
                break;
            }
        }

        return nums[k];
    }

    int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        
        int small = low;
        for (int i = low; i < high; i++) {
            if (nums[i] <= pivot) {
                swap(nums, small, i);
                small++;
            }
        }

        swap(nums, small, high);

        return small;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
