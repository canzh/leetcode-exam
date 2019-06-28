import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 *
 * https://leetcode.com/problems/merge-intervals/description/
 *
 * algorithms
 * Medium (35.58%)
 * Likes:    2160
 * Dislikes: 166
 * Total Accepted:    360.9K
 * Total Submissions: 1M
 * Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
 *
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * Example 1:
 * 
 * 
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into
 * [1,6].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * 
 * NOTE: input types have been changed on April 15, 2019. Please reset to
 * default code definition to get new method signature.
 * 
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        LinkedList<int[]> result = new LinkedList<>();

        for (int i = 0; i < intervals.length; i++) {
            if (result.isEmpty() || intervals[i][0] > result.getLast()[1]) { // not overlap
                result.add(intervals[i].clone());
                continue;
            }

            if (intervals[i][1] > result.getLast()[1]) {
                result.getLast()[1] = intervals[i][1];
            }
        }

        return result.toArray(new int[0][0]);
    }
}
