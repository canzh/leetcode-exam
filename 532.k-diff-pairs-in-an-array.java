import java.util.Map;

/*
 * @lc app=leetcode id=532 lang=java
 *
 * [532] K-diff Pairs in an Array
 *
 * https://leetcode.com/problems/k-diff-pairs-in-an-array/description/
 *
 * algorithms
 * Easy (30.52%)
 * Likes:    418
 * Dislikes: 977
 * Total Accepted:    78.1K
 * Total Submissions: 255.6K
 * Testcase Example:  '[3,1,4,1,5]\n2'
 *
 * 
 * Given an array of integers and an integer k, you need to find the number of
 * unique k-diff pairs in the array. Here a k-diff pair is defined as an
 * integer pair (i, j), where i and j are both numbers in the array and their
 * absolute difference is k.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [3, 1, 4, 1, 5], k = 2
 * Output: 2
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3,
 * 5).Although we have two 1s in the input, we should only return the number of
 * unique pairs.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:[1, 2, 3, 4, 5], k = 1
 * Output: 4
 * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3,
 * 4) and (4, 5).
 * 
 * 
 * 
 * Example 3:
 * 
 * Input: [1, 3, 1, 5, 4], k = 0
 * Output: 1
 * Explanation: There is one 0-diff pair in the array, (1, 1).
 * 
 * 
 * 
 * Note:
 * 
 * The pairs (i, j) and (j, i) count as the same pair.
 * The length of the array won't exceed 10,000.
 * All the integers in the given input belong to the range: [-1e7, 1e7].
 * 
 * 
 */

// @lc code=start
class Solution {
    // Your runtime beats 65.73 % of java submissions
    // Your memory usage beats 89.47 % of java submissions (40.1 MB)
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k < 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int n : nums) {
            if (map.containsKey(n)) {
                if (k == 0 && map.get(n) == 1) {
                    ans++;
                }
                map.put(n, map.get(n) + 1);
            } else {
                if (map.containsKey(n + k)) {
                    ans++;
                }
                if (map.containsKey(n - k)) {
                    ans++;
                }
                map.put(n, 1);
            }
        }
        return ans;
    }

    // Your runtime beats 65.73 % of java submissions
    // Your memory usage beats 84.21 % of java submissions (40.3 MB)
    public int findPairs0(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k < 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                if (entry.getValue() > 1)
                    ans++;
            } else {
                if (map.containsKey(entry.getKey() + k)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    // Your runtime beats 11.2 % of java submissions
    // Your memory usage beats 89.47 % of java submissions (39.8 MB)
    public int findPairs2(int[] nums, int k) {
        if (nums == null || nums.length < 2)
            return 0;
        Arrays.sort(nums);

        int ans = 0, last = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            if (last == nums[i])
                continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] - nums[i] == k) {
                    ans++;
                    break;
                }
            }
            last = nums[i];
        }

        return ans;
    }
}
// @lc code=end
