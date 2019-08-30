import java.util.concurrent.ThreadLocalRandom;

/*
 * @lc app=leetcode id=384 lang=java
 *
 * [384] Shuffle an Array
 *
 * https://leetcode.com/problems/shuffle-an-array/description/
 *
 * algorithms
 * Medium (50.58%)
 * Likes:    306
 * Dislikes: 715
 * Total Accepted:    85.7K
 * Total Submissions: 169.2K
 * Testcase Example:  '["Solution","shuffle","reset","shuffle"]\n[[[1,2,3]],[],[],[]]'
 *
 * Shuffle a set of numbers without duplicates.
 * 
 * 
 * Example:
 * 
 * // Init an array with set 1, 2, and 3.
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 * 
 * // Shuffle the array [1,2,3] and return its result. Any permutation of
 * [1,2,3] must equally likely to be returned.
 * solution.shuffle();
 * 
 * // Resets the array back to its original configuration [1,2,3].
 * solution.reset();
 * 
 * // Returns the random shuffling of array [1,2,3].
 * solution.shuffle();
 * 
 * 
 */
class Solution {
    private int[] origin;

    public Solution(int[] nums) {
        origin = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return origin;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] res = new int[origin.length];
        ThreadLocalRandom random = ThreadLocalRandom.current();

        for (int i = origin.length; i > 0; i--) {
            int r = random.nextInt(0, i);
            res[i - 1] = origin[r];
        }

        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such: Solution obj =
 * new Solution(nums); int[] param_1 = obj.reset(); int[] param_2 =
 * obj.shuffle();
 */
