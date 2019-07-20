import java.util.List;

/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 *
 * https://leetcode.com/problems/permutations/description/
 *
 * algorithms
 * Medium (55.06%)
 * Likes:    2094
 * Dislikes: 62
 * Total Accepted:    391.8K
 * Total Submissions: 703.3K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a collection of distinct integers, return all possible permutations.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,3]
 * Output:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack(nums, result, current);

        return result;
    }

    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> current) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<Integer>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!current.contains(nums[i])) {
                current.add(Integer.valueOf(nums[i]));
                backtrack(nums, result, current);
                current.remove(current.size() - 1);
            }
        }
    }
}
