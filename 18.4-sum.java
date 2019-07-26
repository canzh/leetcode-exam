/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 *
 * https://leetcode.com/problems/4sum/description/
 *
 * algorithms
 * Medium (30.98%)
 * Likes:    1155
 * Dislikes: 231
 * Total Accepted:    246.7K
 * Total Submissions: 796.1K
 * Testcase Example:  '[1,0,-1,0,-2,2]\n0'
 *
 * Given an array nums of n integers and an integer target, are there elements
 * a, b, c, and d in nums such that a + b + c + d = target? Find all unique
 * quadruplets in the array which gives the sum of target.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate quadruplets.
 * 
 * Example:
 * 
 * 
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * 
 * A solution set is:
 * [
 * ⁠ [-1,  0, 0, 1],
 * ⁠ [-2, -1, 1, 2],
 * ⁠ [-2,  0, 0, 2]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, 4, target, 0);
    }

    private List<List<Integer>> kSum(int[] nums, int k, int target, int start) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < k)
            return result;

        if (k == 2) {
            int low = start, high = nums.length - 1;

            while (low < high) {
                int sum = nums[low] + nums[high];

                if (sum == target) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[low]);
                    temp.add(nums[high]);
                    result.add(temp);

                    while (low < high && nums[low] == nums[low + 1])
                        low++;
                    while (low < high && nums[high] == nums[high - 1])
                        high--;

                    low++;
                    high--;
                } else if (sum > target) {
                    high--;
                } else {
                    low++;
                }
            }
        } else {
            for (int i = start; i < nums.length - k + 1; i++) {
                List<List<Integer>> res = kSum(nums, k - 1, target - nums[i], i + 1);

                for (List<Integer> re : res) {
                    re.add(0, nums[i]);
                }
                result.addAll(res);

                while (i < nums.length - 1 && nums[i] == nums[i + 1])
                    i++;
            }
        }

        return result;
    }
}
