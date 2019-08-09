/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 *
 * https://leetcode.com/problems/container-with-most-water/description/
 *
 * algorithms
 * Medium (44.45%)
 * Likes:    3240
 * Dislikes: 434
 * Total Accepted:    371.6K
 * Total Submissions: 834.2K
 * Testcase Example:  '[1,8,6,2,5,4,8,3,7]'
 *
 * Given n non-negative integers a1, a2, ..., an , where each represents a
 * point at coordinate (i, ai). n vertical lines are drawn such that the two
 * endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together
 * with x-axis forms a container, such that the container contains the most
 * water.
 * 
 * Note: You may not slant the container and n is at least 2.
 * 
 * 
 * 
 * 
 * 
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In
 * this case, the max area of water (blue section) the container can contain is
 * 49. 
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * 
 */
class Solution {
    /*
     * I have an alternative proof:
     * 
     * We starts with the widest container, l = 0 and r = n - 1. Let's say the left
     * one is shorter: h[l] < h[r]. Then, this is already the largest container the
     * left one can possibly form. There's no need to consider it again. Therefore,
     * we just throw it away and start again with l = 1 and r = n -1.
     * 
     * 我们假设 1 号 和 8 号 柱子高度是相等的。 如果他们之间的柱子只有 1 根比它俩高或者没有比它俩高的， 那么最大面积就一定选取是 1 号和 8
     * 号了，所以 1 号接着变大， 或者 8 号接着减小都是无所谓的，因为答案已经确定了。
     */
    public int maxArea(int[] height) {
        int low = 0, high = height.length - 1;
        int max = 0;

        while (low < high) {
            max = Math.max(max, Math.min(height[low], height[high]) * (high - low));
            if (height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
        }

        return max;
    }
}
