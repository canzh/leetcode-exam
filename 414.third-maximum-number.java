/*
 * @lc app=leetcode id=414 lang=java
 *
 * [414] Third Maximum Number
 */

// @lc code=start
class Solution {
    public int thirdMax(int[] nums) {
        Integer max1 = null, max2 = null, max3 = null;
        for (Integer i : nums) {
            if (i.equals(max1) || i.equals(max2) || i.equals(max3))
                continue;
            if (max1 == null || max1 < i) {
                max3 = max2;
                max2 = max1;
                max1 = i;
            } else if (max2 == null || max2 < i) {
                max3 = max2;
                max2 = i;
            } else if (max3 == null || max3 < i) {
                max3 = i;
            }
        }
        return max3 == null ? max1 : max3;
    }
}
// @lc code=end
