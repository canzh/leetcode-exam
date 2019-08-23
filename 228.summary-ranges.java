import java.util.Arrays;
import java.util.Collections;

/*
 * @lc app=leetcode id=228 lang=java
 *
 * [228] Summary Ranges
 *
 * https://leetcode.com/problems/summary-ranges/description/
 *
 * algorithms
 * Medium (36.54%)
 * Likes:    407
 * Dislikes: 404
 * Total Accepted:    137.8K
 * Total Submissions: 376.4K
 * Testcase Example:  '[0,1,2,4,5,7]'
 *
 * Given a sorted integer array without duplicates, return the summary of its
 * ranges.
 * 
 * Example 1:
 * 
 * 
 * Input:  [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:  [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
 * 
 * 
 */
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            while (i + 1 < nums.length && nums[i + 1] - nums[i] == 1) {
                i++;
            }

            if (a == nums[i]) {
                result.add(String.valueOf(a));
            } else {
                result.add(a + "->" + nums[i]);
            }
        }

        return result;
    }

    public List<String> summaryRanges2(int[] nums) {
        if (nums == null || nums.length == 0)
            return Collections.EMPTY_LIST;
        if (nums.length == 1)
            return Arrays.asList(String.valueOf(nums[0]));

        int start = nums[0], end = nums[0];
        List<String> result = new LinkedList<>();

        for (int i = 1; i < nums.length; i++) {
            if (end + 1 != nums[i]) {
                if (start == end) {
                    result.add(String.valueOf(start));
                } else {
                    result.add(start + "->" + end);
                }
                start = nums[i];
            }

            end = nums[i];

            if (i == nums.length - 1) {
                if (start == end) {
                    result.add(String.valueOf(start));
                } else {
                    result.add(start + "->" + end);
                }
            }
        }

        return result;
    }
}
