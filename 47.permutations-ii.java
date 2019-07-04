import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 *
 * https://leetcode.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (40.40%)
 * Likes:    1043
 * Dislikes: 44
 * Total Accepted:    251.1K
 * Total Submissions: 612.9K
 * Testcase Example:  '[1,1,2]'
 *
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * Example:
 * 
 * 
 * Input: [1,1,2]
 * Output:
 * [
 * ⁠ [1,1,2],
 * ⁠ [1,2,1],
 * ⁠ [2,1,1]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        List<Integer> possibleValues = Arrays.stream(nums).boxed().collect(Collectors.toList());

        backtrack(nums, result, current, possibleValues);

        return result;
    }

    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> current,
            List<Integer> possibleValues) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<Integer>(current));
            return;
        }

        List<Integer> placedValue = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (possibleValues.contains(nums[i])
                && !placedValue.contains(Integer.valueOf(nums[i]))) {
                placedValue.add(nums[i]);

                current.add(Integer.valueOf(nums[i]));
                possibleValues.remove(Integer.valueOf(nums[i]));

                backtrack(nums, result, current, possibleValues);

                current.remove(current.size() - 1);
                possibleValues.add(nums[i]);
            }
        }
    }

    // private boolean isValid(int value, List<Integer> possibleValues) {
    // return possibleValues.contains(value);
    // }
}
